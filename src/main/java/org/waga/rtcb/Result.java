package org.waga.rtcb;

import org.waga.player.Player;

public class Result {

	private Player player;
	private int handicap;
	private int score;
	private boolean countbackWinner;

	public Result(Player player, int handicap, int score) {
		this(player, handicap, score, false);
	}

	public Result(Player player, int handicap, int score, boolean countbackWinner) {
		super();
		this.player = player;
		this.handicap = handicap;
		this.score = score;
		this.countbackWinner = countbackWinner;
	}

	public Player getPlayer() {
		return player;
	}

	public int getHandicap() {
		return handicap;
	}

	public int getScore() {
		return score;
	}

	public boolean isCountbackWinner() {
		return countbackWinner;
	}

	@Override
	public String toString() {
		return "Result [player=" + player + ", handicap=" + handicap + ", score=" + score + ", countbackWinner="
				+ countbackWinner + "]";
	}

}
