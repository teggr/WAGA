package org.waga.rtcb;

import java.util.List;
import java.util.Set;

import org.waga.player.Player;

public class RaceToCiaoBellaScoreHandicapAdjuster {

	public void apply(RaceToCiaoBella raceToCiaoBella) {

		List<Tournament> tournaments = raceToCiaoBella.getTournamentsSortedByDate();

		for (Tournament tournament : tournaments) {

			Set<Result> results = tournament.getResults();
			for (Result result : results) {
				Player p = result.getPlayer();
				if (result.getScore() >= 40) {
					p.decrementHandicap(2, "40 points or over");
				} else if (result.getScore() >= 38) {
					p.decrementHandicap(1, "38 points or over");
				} else if (result.getScore() <= 27) {
					p.incrementHandicap(1, "27 points or less");
				}

			}

		}

	}

}
