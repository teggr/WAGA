package org.waga.seedings;

import org.waga.player.Player;

public class Seeding {

	private Player player;

	public Seeding(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public int getHandicap() {
		return player.getCurrentHandicap();
	}

}
