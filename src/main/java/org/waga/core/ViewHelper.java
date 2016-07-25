package org.waga.core;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.woodmancup.Team;

public class ViewHelper {

	public String elapsedTime(Date createdDate) {

		LocalDate localDate = createdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate now = LocalDate.now();

		Period period = Period.between(localDate, now);

		if (period.getYears() > 0) {
			return period.getYears() + "y";
		}
		if (period.getMonths() > 0) {
			return period.getMonths() + "m";
		}
		return period.getDays() + "d";
	}

	public List<Player> byListAppearanceDate(List<Player> profiles) {
		return profiles.stream().sorted((p1, p2) -> p1.getLastAppearance().compareTo(p2.getLastAppearance()))
				.collect(Collectors.toList());
	}

	public String getProfileId(Player profile) {
		return profile.getFullName().toLowerCase().replaceAll(" ", "-").replaceAll("'", "");
	}

	public static class PlayerPair {

		private Player player1;
		private Player player2;

		public PlayerPair(Player player1, Player player2) {
			this.player1 = player1;
			this.player2 = player2;
		}

		public Player getPlayer1() {
			return player1;
		}

		public Player getPlayer2() {
			return player2;
		}

	}

	public Iterable<PlayerPair> getTeamRows(Team team1, Team team2) {
		List<PlayerPair> list = new ArrayList<>();
		int max = Math.max(team1.getPlayers().size(), team2.getPlayers().size());
		for (int i = 0; i < max; i++) {
			list.add(new PlayerPair(getPlayer(i, team1), getPlayer(i, team2)));
		}
		return list;
	}

	private Player getPlayer(int index, Team team2) {
		try {
			return team2.getPlayers().get(index);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
