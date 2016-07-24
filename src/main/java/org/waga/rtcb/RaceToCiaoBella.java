package org.waga.rtcb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaceToCiaoBella {

	private int season;

	private Set<Tournament> tournaments = new HashSet<>();

	public RaceToCiaoBella(int season) {
		super();
		this.season = season;
	}

	public int getSeason() {
		return season;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void addTournament(Tournament tour) {
		tournaments.add(tour);
	}

	public List<Tournament> getTournamentsSortedByRecent() {
		List<Tournament> sortedTournaments = new ArrayList<>(tournaments);
		Collections.sort(sortedTournaments, (t1, t2) -> t2.getDate().compareTo(t1.getDate()));
		return sortedTournaments;
	}

	@Override
	public String toString() {
		return "RaceToCiaoBella [season=" + season + ", tournaments=" + tournaments + "]";
	}

}
