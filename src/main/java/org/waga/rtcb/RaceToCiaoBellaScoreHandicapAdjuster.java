package org.waga.rtcb;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.waga.player.Player;

public class RaceToCiaoBellaScoreHandicapAdjuster {

	private static final Logger log = LoggerFactory.getLogger(RaceToCiaoBellaScoreHandicapAdjuster.class);

	public void apply(RaceToCiaoBella raceToCiaoBella) {

		log.info("Adjusting handicaps based on Race to cia bella scores");

		List<Tournament> tournaments = raceToCiaoBella.getTournamentsSortedByDate();

		for (Tournament tournament : tournaments) {

			Date date = tournament.getDate();

			Set<Result> results = tournament.getResults();
			for (Result result : results) {
				Player p = result.getPlayer();
				if (result.getScore() >= 40) {
					String message = "40 points or over";
					log.info(p.getFullName() + " adjusted " + message);
					p.decrementHandicap(2, message, date);
				} else if (result.getScore() >= 38) {
					String message = " 38 points or over";
					log.info(p.getFullName() + " adjusted " + message, date);
					p.decrementHandicap(1, message, date);
				} else if (result.getScore() <= 27) {
					String message = " 27 points or less";
					log.info(p.getFullName() + " adjusted " + message);
					p.incrementHandicap(1, message, date);
				}

			}

		}

	}

}