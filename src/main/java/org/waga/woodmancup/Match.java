package org.waga.woodmancup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.woodmancup.Match.MatchBuilder;

public class Match {

	public static enum Result {
		WIN, LOSE, DRAW;
	}

	public static class MatchBuilder {

		private List<Player> teamA;
		private List<Player> teamB;
		private Result result;

		public Match build() {
			return new Match(this);
		}

		public MatchBuilder teamOf(Players... players) {
			teamA = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

		public MatchBuilder beat(Players... players) {
			result = Result.WIN;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

		public MatchBuilder drewWith(Players... players) {
			result = Result.DRAW;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

		public MatchBuilder lostTo(Players... players) {
			result = Result.LOSE;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

	}

	public static final String DRAW = "draw";

	public Match(MatchBuilder matchBuilder) {
		// TODO Auto-generated constructor stub
	}

	public static Match newInstance(String winningTeamId, Group... groups) {
		Match match = new Match();
		match.winningTeamId = winningTeamId;
		match.groups = Arrays.asList(groups);
		return match;
	}

	private List<Group> groups;
	private String winningTeamId;

	public List<Group> getGroups() {
		return groups;
	}

	public String getWinningTeamId() {
		return winningTeamId;
	}

	public boolean containsMember(String memberId) {
		for (Group group : groups) {
			if (group.containsMember(memberId)) {
				return true;
			}
		}
		return false;
	}

}
