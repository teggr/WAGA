package org.waga.woodmancup.statistics;

import org.waga.player.Player;

public class PlayingRecord {

	private final Player player;
	private int wins = 0;
	private int losses = 0;
	
	public PlayingRecord(Player player) {
		super();
		this.player = player;
	}

	public void recordWin() {
		wins++;
	}
	
	public int getWins() {
		return wins;
	}

	public void recordLoss() {
		losses ++;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public Player getPlayer() {
		return player;
	}

}
