package org.waga.woodmancup;

import java.util.ArrayList;
import java.util.List;

import org.waga.player.Player;
import org.waga.player.Players;

public class Team {

	public static Team newInstance(String name, String colour, Players captain) {
		Team team = new Team();
		team.captain = captain.asPlayer();
		team.name = name;
		team.colour = colour;
		return team;
	}

	public static Team newInstanceAsWinner(String name, String colour, Players captain) {
		Team team = new Team();
		team.captain = captain.asPlayer();
		team.name = name;
		team.colour = colour;
		team.isWinner = true;
		return team;
	}

	private Player captain;
	private String name;
	private String colour;
	private boolean isWinner = false;
	private List<Player> players = new ArrayList<Player>();

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public Player getCaptain() {
		return captain;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public boolean isPlayer(Player player) {
		return players.contains(player);
	}

	public boolean isCaptain(Player player) {
		return captain.getSurname().equals(player.getSurname());
	}

	public boolean isPlayer(List<Player> players) {
		for (Player player : players) {
			if (isPlayer(player)) {
				return true;
			}
		}
		return false;
	}

}
