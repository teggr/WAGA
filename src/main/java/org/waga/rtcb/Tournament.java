package org.waga.rtcb;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.waga.core.AbstractEntity;
import org.waga.venue.Venue;

@Entity
public class Tournament extends AbstractEntity {

	@ManyToOne
	private RaceToCiaoBella raceToCiaoBella;

	@ManyToOne
	private Venue venue;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tournament")
	private Set<Result> results;

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

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
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
		return "Tournament [venue=" + venue + ", date=" + date + ", name=" + name + ", results=" + results + "]";
	}

	public void deleteResult(Long resultId) {
		Optional<Result> match = results.stream().filter(t -> t.getId().equals(resultId)).findFirst();
		if (match.isPresent()) {
			Result result = match.get();
			results.remove(result);
			result.setTournament(null);
		}

	}

}
