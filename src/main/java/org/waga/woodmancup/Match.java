package org.waga.woodmancup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;

public class Match {

	public static enum Result {
		BEAT, LOSE_TO, DRAW_WITH;
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
			result = Result.BEAT;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

		public MatchBuilder drewWith(Players... players) {
			result = Result.DRAW_WITH;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

		public MatchBuilder lostTo(Players... players) {
			result = Result.LOSE_TO;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

	}

	private List<Player> teamA;
	private List<Player> teamB;
	private Result teamAResult;

	public Match(MatchBuilder matchBuilder) {
		teamA = matchBuilder.teamA;
		teamB = matchBuilder.teamB;
		teamAResult = matchBuilder.result;
	}

	public double getTeamAPoints() {
		if (teamAResult == Result.BEAT) {
			return 1;
		} else if (teamAResult == Result.DRAW_WITH) {
			return 0.5;
		} else {
			return 0;
		}
	}

	public double getTeamBPoints() {
		if (teamAResult == Result.BEAT) {
			return 0;
		} else if (teamAResult == Result.DRAW_WITH) {
			return 0.5;
		} else {
			return 1;
		}
	}

	public List<Player> getTeamA() {
		return teamA;
	}

	public Result getTeamAResult() {
		return teamAResult;
	}

	public List<Player> getTeamB() {
		return teamB;
	}

	public String getTeamANames() {
		return getTeamNames(teamA);
	}

	public String getTeamBNames() {
		return getTeamNames(teamB);
	}

	private String getTeamNames(List<Player> team) {
		return team.stream().map(p -> p.getSurname()).collect(Collectors.joining(","));
	}
}
