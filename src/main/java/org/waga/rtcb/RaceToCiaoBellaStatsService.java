package org.waga.rtcb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.waga.core.Player;
import org.waga.core.Ranking;

@Component
public class RaceToCiaoBellaStatsService {

	@Autowired
	private RaceToCiaoBellaRepository raceToCiaoBellaRepository;

	public TournamentSummary getLastTournamentSummary() {

		RaceToCiaoBella lastRace = raceToCiaoBellaRepository.findLastByOrderBySeason();
		if (lastRace != null) {
			Optional<Tournament> first = lastRace.getTournaments().stream()
					.sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate())).findFirst();
			if (first.isPresent()) {
				return new TournamentSummary(first.get());
			}
		}
		return null;

	}

	public List<RaceToCiaoBellaRanking> getRankings() {

		RaceToCiaoBella race = raceToCiaoBellaRepository.findLastByOrderBySeason();

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

		List<RaceToCiaoBellaRanking> rankings = leaders.values().stream().map(t -> {
			RaceToCiaoBellaRanking rl = new RaceToCiaoBellaRanking();
			rl.setPlayed(t.getSize());
			rl.setPlayer(t.getPlayer().getSurname());
			rl.setPosition(1);
			rl.setPoints(t.getTotal());
			return rl;
		}).sorted((t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints())).collect(Collectors.toList());

		Ranking.rank(rankings);

		return rankings;

	}

	private static class Totals {
		private List<Integer> totals = new ArrayList<>();
		private Player player;

		public Totals(Player player) {
			this.player = player;
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
			return totals.stream().mapToInt(Integer::intValue).sum();
		}
	}

	public List<TournamentSummary> getTournamentSummaries() {

		RaceToCiaoBella lastRace = raceToCiaoBellaRepository.findLastByOrderBySeason();
		if (lastRace != null) {
			return lastRace.getTournaments().stream().sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
					.map(t -> new TournamentSummary(t)).collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}

	}

}
