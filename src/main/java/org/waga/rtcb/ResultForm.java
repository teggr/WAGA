package org.waga.rtcb;

public class ResultForm {

	private Long playerId;
	private int handicap;
	private int score;

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
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
		return "ResultForm [playerId=" + playerId + ", handicap=" + handicap + ", score=" + score + "]";
	}

	public void update(Result result) {
		result.setHandicap(handicap);
		result.setScore(score);
	}

}
