package org.waga.woodmancup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;

public class Match {

	public static enum Result {
		BEAT, LOST_TO, DREW_WITH;
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
			result = Result.DREW_WITH;
			teamB = Arrays.asList(players).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
			return this;
		}

		public MatchBuilder lostTo(Players... players) {
			result = Result.LOST_TO;
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
		return getPoints(teamAResult);
	}

	public double getTeamBPoints() {
		return getPoints(teamBResult());
	}

	private double getPoints(Result result) {
		if (result == Result.BEAT) {
			return 1;
		} else if (result == Result.DREW_WITH) {
			return 0.5;
		} else {
			return 0;
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
		return team.stream().map(p -> p.getSurname()).collect(Collectors.joining(" - "));
	}

	public Result getResult(Player player) {
		if (teamA.contains(player)) {
			return teamAResult;
		} else {
			return teamBResult();
		}
	}

	private Result teamBResult() {
		if (teamAResult == Result.BEAT) {
			return Result.LOST_TO;
		} else if (teamAResult == Result.LOST_TO) {
			return Result.BEAT;
		} else {
			return Result.DREW_WITH;
		}
	}

	public boolean withPlayer(Player player) {
		return teamA.contains(player) || teamB.contains(player);
	}

	@Override
	public String toString() {
		return "Match [teamA=" + teamA + ", teamAResult=" + teamAResult + ", teamB=" + teamB + "]";
	}

	public double getTeamPoints(Team team) {
		if( team.isPlayer(teamA) ) {
			return getTeamAPoints();
		} else {
			return getTeamBPoints();
		}
	}

}
