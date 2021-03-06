package org.waga.woodmancup.statistics;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.waga.player.Player;
import org.waga.woodmancup.Match;

public class PlayerStats {

	public static Comparator<PlayerStats> RECENT_PLAYER_STATS = new Comparator<PlayerStats>() {
		@Override
		public int compare(PlayerStats o1, PlayerStats o2) {
			int dateCompare = o2.lastAttended.compareTo(o1.lastAttended);
			if (dateCompare != 0) {
				return dateCompare;
			}
			return o1.player.getFullName().compareToIgnoreCase(o2.player.getFullName());
		}
	};

	private final Player player;
	private final List<Match> matches;
	private final Date lastAttended;
	private final List<PlayingRecord> playingRecords;
	private final List<FormatRecord> formatRecords;
	private final List<SessionRecord> sessionRecords;

	public PlayerStats(Player player, Date lastAttended, List<Match> matches, List<PlayingRecord> playingRecords,
			List<FormatRecord> formatRecords, List<SessionRecord> sessionRecords) {
		this.player = player;
		this.lastAttended = lastAttended;
		this.matches = matches;
		this.playingRecords = playingRecords;
		this.formatRecords = formatRecords;
		this.sessionRecords = sessionRecords;
	}

	public Collection<SessionRecord> getSessionRecords() {
		return sessionRecords;
	}

	public Collection<FormatRecord> getFormatRecords() {
		return formatRecords;
	}

	public Player getPlayer() {
		return player;
	}

	public Date getLastAttended() {
		return lastAttended;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public Collection<PlayingRecord> getPlayingRecords() {
		return playingRecords;
	}

}
