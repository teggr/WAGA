package org.waga.rtcb;

import java.util.Date;
import java.util.List;

import org.waga.player.Player;

public class RaceToCiaoBellaWinningHandicapAdjuster {

	private Date date;

	public RaceToCiaoBellaWinningHandicapAdjuster(Date applyFromDate) {
		this.date = applyFromDate;
	}

	public void apply(RaceToCiaoBella raceToCiaoBella) {

		List<Tournament> tournaments = raceToCiaoBella.getTournamentsSortedByDate();

		for (Tournament tournament : tournaments) {

			if (tournament.getDate().compareTo(date) > 0) {

				Player p = tournament.getWinner();
				p.decrementHandicap(1, "Tournament winner");

			}

		}

	}

}
