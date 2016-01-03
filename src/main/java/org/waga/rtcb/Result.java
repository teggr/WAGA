package org.waga.rtcb;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.waga.core.AbstractEntity;
import org.waga.core.Player;

@Entity
public class Result extends AbstractEntity {

	@ManyToOne
	private Player player;
	private int handicap;
	private int score;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
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
