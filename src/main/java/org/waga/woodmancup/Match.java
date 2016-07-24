package org.waga.woodmancup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;

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

	private List<Player> teamA;
	private List<Player> teamB;
	private Result teamAResult;

	public Match(MatchBuilder matchBuilder) {
		teamA = matchBuilder.teamA;
		teamB = matchBuilder.teamB;
		teamAResult = matchBuilder.result;
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
}
