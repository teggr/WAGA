package org.waga.rtcb;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.waga.player.Player;

public class RaceToCiaoBellaWinningHandicapAdjuster {

	private static final Logger log = LoggerFactory.getLogger(RaceToCiaoBellaWinningHandicapAdjuster.class);
	private Date applyFromDate;

	public RaceToCiaoBellaWinningHandicapAdjuster(Date applyFromDate) {
		this.applyFromDate = applyFromDate;
	}

	public void apply(RaceToCiaoBella raceToCiaoBella) {

		List<Tournament> tournaments = raceToCiaoBella.getTournamentsSortedByDate();

		for (Tournament tournament : tournaments) {

			Date date = tournament.getDate();
			if (date.after(applyFromDate)) {

				Player p = tournament.getWinner();
				String message = "Tournament winner";
				log.info(p.getFullName() + " adjusted " + message);
				p.decrementHandicap(1, message, date);

			}

		}

	}

}
