package org.waga.rtcb;

import java.util.HashSet;
import java.util.Set;

public class RaceToCiaoBella {

	private int season;

	private Set<Tournament> tournaments = new HashSet<>();

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public Set<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(Set<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	@Override
	public String toString() {
		return "RaceToCiaoBella [season=" + season + ", tournaments=" + tournaments + "]";
	}

	public void addTournaments(Tournament tour) {
		tournaments.add(tour);
	}

}
