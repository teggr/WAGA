package org.waga.rtcb;

import org.waga.core.AbstractEntity;
import org.waga.player.PlayerProfile;

public class Result {

	private Tournament tournament;

	private PlayerProfile player;
	private int handicap;
	private int score;

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public PlayerProfile getPlayer() {
		return player;
	}

	public void setPlayer(PlayerProfile player) {
		this.player = player;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Result [player=" + player + ", handicap=" + handicap + ", score=" + score + "]";
	}

}
