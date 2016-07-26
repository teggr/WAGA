package org.waga.rtcb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.waga.core.Ranking;
import org.waga.player.Player;

public class RaceToCiaoBellaStats {

	private List<RaceToCiaoBellaRanking> rankings;

	public RaceToCiaoBellaStats(RaceToCiaoBella race) {

		Map<String, Totals> leaders = new HashMap<>();

		if (race != null) {
			for (Tournament round : race.getTournaments()) {

				Set<Result> results = round.getResults();
				for (Result result : results) {
					Player player = result.getPlayer();
					Totals totals = leaders.get(player.getSurname());
					if (totals == null) {
						totals = new Totals(player);
						leaders.put(player.getSurname(), totals);
					}
					totals.addScore(result.getScore());
				}

			}
		}

		rankings = leaders.values().stream().map(t -> {
			RaceToCiaoBellaRanking rl = new RaceToCiaoBellaRanking();
			rl.setPlayed(t.getSize());
			rl.setPlayer(t.getPlayer().getSurname());
			rl.setPosition(1);
			rl.setPoints(t.getTotal(), t.getTopScores());
			return rl;
		}).sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints())).collect(Collectors.toList());

		Ranking.rank(rankings);

	}

	public List<RaceToCiaoBellaRanking> getRankings() {
		return rankings;
	}

	private static class Totals {
		private List<Integer> totals = new ArrayList<>();
		private Player player;

		public Totals(Player player) {
			this.player = player;
		}

		public List<Integer> getTopScores() {
			return totals.stream().sorted((t1, t2) -> t2.compareTo(t1)).limit(4).collect(Collectors.toList());
		}

		public int getSize() {
			return totals.size();
		}

		public Player getPlayer() {
			return player;
		}

		public void addScore(int score) {
			totals.add(score);
		}

		public int getTotal() {
			return getTopScores().stream().mapToInt(Integer::intValue).sum();
		}
	}

}
