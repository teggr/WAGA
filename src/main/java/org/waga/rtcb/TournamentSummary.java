package org.waga.rtcb;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.waga.core.Ranking;

public class TournamentSummary {

	private String name;
	private Date date;
	private List<FinalResult> orderResults;

	public TournamentSummary(Tournament tournament) {
		name = tournament.getVenue().getName();
		date = tournament.getDate();
		orderResults = orderResults(tournament.getResults());
		Ranking.rank(orderResults);
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public List<FinalResult> getFinalResults() {
		return orderResults;
	}

	private List<FinalResult> orderResults(Set<Result> results) {
		return results.stream().map(r -> new FinalResult(r))
				.sorted((r1, r2) -> Integer.compare(r2.getScore(), r1.getScore())).collect(Collectors.toList());
	}
}
