package org.waga.rtcb;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.waga.core.AbstractEntity;

@Entity
public class RaceToCiaoBella extends AbstractEntity {

	private int season;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "race_season_id")
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

}
