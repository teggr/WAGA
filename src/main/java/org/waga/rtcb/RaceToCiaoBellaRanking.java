package org.waga.rtcb;

import java.util.List;
import java.util.stream.Collectors;

import org.waga.core.Rankable;

public class RaceToCiaoBellaRanking implements Rankable {

	private int position;
	private String player;
	private int played;
	private int points;
	private List<Integer> topScores;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points, List<Integer> topScores) {
		this.points = points;
		this.topScores = topScores;
	}

	@Override
	public int getRankableValue() {
		return points;
	}

	@Override
	public void setRanking(int ranking) {
		position = ranking;
	}

	public String getTopScores() {
		return topScores.stream().map(i -> i.toString()).collect(Collectors.joining(" - "));
	}

	@Override
	public String toString() {
		return "RaceToCiaoBellaLeader [position=" + position + ", player=" + player + ", played=" + played + ", points="
				+ points + "]";
	}

}
