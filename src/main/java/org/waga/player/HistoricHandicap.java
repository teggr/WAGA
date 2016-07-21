package org.waga.player;

import java.util.Comparator;
import java.util.Date;

public class HistoricHandicap {

	public static final Comparator<HistoricHandicap> REVERSE_DATE_ORDER = new Comparator<HistoricHandicap>() {
		@Override
		public int compare(HistoricHandicap o1, HistoricHandicap o2) {
			return o1.expiredDate.compareTo(o2.expiredDate);
		}
	};

	private Date expiredDate;
	private int handicap;

	private Player player;

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}

}
