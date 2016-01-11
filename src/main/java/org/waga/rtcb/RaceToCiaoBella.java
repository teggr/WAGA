package org.waga.rtcb;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.waga.core.AbstractEntity;

@Entity
public class RaceToCiaoBella extends AbstractEntity {

	private int season;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "raceToCiaoBella")
	private Set<Tournament> tournaments;

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

	public void update(RaceToCiaoBella rtcb) {
		this.season = rtcb.season;
	}

	public void addTournaments(Tournament tour) {
		tournaments.add(tour);
		tour.setRaceToCiaoBella(this);
	}

	public Tournament findTournamentById(Long tid) {
		if (tournaments.isEmpty()) {
			return null;
		}
		return tournaments.stream().filter(t -> t.getId().equals(tid)).findFirst().get();
	}

	public Tournament findTournamentByName(String name) {
		if (tournaments.isEmpty()) {
			return null;
		}
		return tournaments.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public Tournament findLastTournament() {
		if (tournaments.isEmpty()) {
			return null;
		}
		return tournaments.stream().sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate())).findFirst().get();
	}

	public void removeTournament(Long tid) {
		Tournament tour = findTournamentById(tid);
		tournaments.remove(tour);
		tour.setRaceToCiaoBella(null);
	}

}
