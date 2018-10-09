package org.waga.woodmancup.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.waga.player.Player;
import org.waga.woodmancup.Match;
import org.waga.woodmancup.Match.Result;
import org.waga.woodmancup.Session;
import org.waga.woodmancup.Session.Format;
import org.waga.woodmancup.WoodmanCupEvent;

public class PlayerDataCollector {

	private Player player;
	private List<WoodmanCupRecord> records = new ArrayList<>();
	private List<Match> matchList = new ArrayList<>();
	private Date lastAttended;
	private Map<Player, PlayingRecord> playingRecords = new HashMap<>();
	private Map<Format, FormatRecord> formatRecords = new HashMap<>();

	public PlayerDataCollector(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void aggregate(WoodmanCupEvent event) {
		if (event.wasAttendedBy(player)) {
			calculateLastAttended(event);
			WoodmanCupRecord record = new WoodmanCupRecord();
			List<Session> sessions = event.getSessions();
			for (Session session : sessions) {
				List<Match> matches = session.getMatches();
				for (Match match : matches) {
					if (match.withPlayer(player)) {
						Result result = match.getResult(player);
						record.addResult(result);
						matchList.add(match);
						if (result == Result.BEAT) {
							recordVictoryAgainstPlayers(match);
							recordSessionVictory(session);
						} else if (result == Result.LOST_TO) {
							recordLossAgainstPlayers(match);
							recordSessionLoss(session);
						}
					}
				}
			}
			if (event.getPuttOffWinner() == player) {
				record.addPuttOffWin();
			}
			if (event.getAlternativeWoodmanCupWinner() == player) {
				record.addAlternativeWoodmanCupWin();
			}
			if (event.inWinningTeam(player)) {
				record.addWoodmanCupWin();
			}
			records.add(record);
		}
	}

	private void recordSessionLoss(Session session) {
		FormatRecord formatRecord = formatRecords.get(session.getFormat());
		if (formatRecord == null) {
			formatRecord = new FormatRecord(session.getFormat());
			formatRecords.put(session.getFormat(), formatRecord);
		}
		formatRecord.recordLoss();
	}

	private void recordSessionVictory(Session session) {
		FormatRecord formatRecord = formatRecords.get(session.getFormat());
		if (formatRecord == null) {
			formatRecord = new FormatRecord(session.getFormat());
			formatRecords.put(session.getFormat(), formatRecord);
		}
		formatRecord.recordWin();
	}

	private void recordLossAgainstPlayers(Match match) {
		for (Player opponent : match.getOpponents(player)) {
			PlayingRecord playingRecord = playingRecords.get(opponent);
			if (playingRecord == null) {
				playingRecord = new PlayingRecord(opponent);
				playingRecords.put(opponent, playingRecord);
			}
			playingRecord.recordLoss();
		}
	}

	private void recordVictoryAgainstPlayers(Match match) {
		for (Player opponent : match.getOpponents(player)) {
			PlayingRecord playingRecord = playingRecords.get(opponent);
			if (playingRecord == null) {
				playingRecord = new PlayingRecord(opponent);
				playingRecords.put(opponent, playingRecord);
			}
			playingRecord.recordWin();
		}
	}

	private void calculateLastAttended(WoodmanCupEvent event) {
		if (lastAttended == null) {
			lastAttended = event.getDate();
		} else {
			if (event.getDate().after(lastAttended)) {
				lastAttended = event.getDate();
			}
		}
	}

	public HallOfFameEntry toHallOfFameEntry() {
		int appearances = records.size();
		int victories = records.stream().mapToInt(r -> r.isWoodmanCupWin() ? 1 : 0).sum();
		int alternativeWoodmanCupWins = records.stream().mapToInt(r -> r.isAlternativeWoodmanCupWin() ? 1 : 0).sum();
		int puttOffWins = records.stream().mapToInt(r -> r.isPuttOffWin() ? 1 : 0).sum();
		int wins = records.stream().mapToInt(r -> r.getWins()).sum();
		int draws = records.stream().mapToInt(r -> r.getDraws()).sum();
		int losses = records.stream().mapToInt(r -> r.getLosses()).sum();

		return new HallOfFameEntry(appearances, victories, alternativeWoodmanCupWins, puttOffWins, wins, draws, losses,
				player);
	}

	@Override
	public String toString() {
		return "PlayerDataCollector [player=" + player.getFullName() + "]";
	}

	public boolean isPlayer(Player p) {
		return p == player;
	}

	public PlayerStats getStats() {
		return new PlayerStats(player, lastAttended, matchList, playingRecords.values(), formatRecords.values());
	}

}
