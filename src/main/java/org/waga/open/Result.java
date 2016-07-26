package org.waga.open;

import org.waga.player.Player;

public class Result {

	private Player player;
	private int points;

	public Result(Player player, int points) {
		this.player = player;
		this.points = points;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getPoints() {
		return points;
	}

}
