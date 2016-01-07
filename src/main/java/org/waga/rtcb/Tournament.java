package org.waga.rtcb;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.waga.core.AbstractEntity;

@Entity
public class Tournament extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "race_season_id")
	private RaceToCiaoBella raceToCiaoBella;

	private Long venueId;

	@Temporal(TemporalType.DATE)
	private Date date;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tournament")
	private Set<Result> results;
	
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}
	
	public Long getVenueId() {
		return venueId;
	}

	public RaceToCiaoBella getRaceToCiaoBella() {
		return raceToCiaoBella;
	}

	public void setRaceToCiaoBella(RaceToCiaoBella raceToCiaoBella) {
		this.raceToCiaoBella = raceToCiaoBella;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Result> getResults() {
		return results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	public void addResult(Result result) {
		results.add(result);
		result.setTournament(this);
	}

	@Override
	public String toString() {
		return "Tournament [venueId=" + venueId + ", date=" + date + ", name=" + name + ", results=" + results + "]";
	}

}
