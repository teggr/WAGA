package org.waga.wc;

public class WoodmanCupLeader {
	private int position;
	private String player;
	private int played;
	private int points;

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

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "WoodmanCupLeader [position=" + position + ", player=" + player + ", played=" + played + ", points="
				+ points + "]";
	}
}
