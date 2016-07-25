package org.waga.woodmancup.statistics;

import java.util.ArrayList;
import java.util.List;

import org.waga.player.Player;
import org.waga.woodmancup.Match;
import org.waga.woodmancup.Match.Result;
import org.waga.woodmancup.Session;
import org.waga.woodmancup.WoodmanCupEvent;

public class PlayerDataCollector {

	private Player player;
	private List<WoodmanCupRecord> records = new ArrayList<>();

	public PlayerDataCollector(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void aggregate(WoodmanCupEvent event) {
		if (event.wasAttendedBy(player)) {
			WoodmanCupRecord record = new WoodmanCupRecord();
			List<Session> sessions = event.getSessions();
			for (Session session : sessions) {
				List<Match> matches = session.getMatches();
				for (Match match : matches) {
					if( match.withPlayer(player) ) {
						Result result = match.getResult(player);
						record.addResult(result);
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

}
