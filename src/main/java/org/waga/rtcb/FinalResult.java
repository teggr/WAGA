package org.waga.rtcb;

import org.waga.core.Rankable;

public class FinalResult implements Rankable {

	private String name;
	private int handicap;
	private int score;
	private int position = 1;

	public FinalResult(Result result) {
		name = result.getPlayer().getFullName();
		handicap = result.getHandicap();
		score = result.getScore();
	}

	public int getHandicap() {
		return handicap;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public int getPosition() {
		return position;
	}

	public void setRanking(int ranking) {
		this.position = ranking;
	}

	@Override
	public int getRankableValue() {
		return score;
	}

	@Override
	public String toString() {
		return "FinalResult [name=" + name + ", handicap=" + handicap + ", score=" + score + ", position=" + position
				+ "]";
	}

}
