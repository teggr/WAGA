package org.waga.rtcb;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.venue.Venue;

public class Tournament {

	private Venue venue;

	private Date date;
	private String name;

	private Set<Result> results = new HashSet<>();

	public Tournament(String name, Date date, Venue venue) {
		super();
		this.venue = venue;
		this.date = date;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Venue getVenue() {
		return venue;
	}

	public Date getDate() {
		return date;
	}

	public Set<Result> getResults() {
		return results;
	}

	public List<Result> sortedResults() {
		return results.stream().sorted(new Comparator<Result>() {
			@Override
			public int compare(Result r1, Result r2) {
				int scoreDiff = r2.getScore() - r1.getScore();
				if (scoreDiff == 0) {
					if (r1.isCountbackWinner()) {
						return -1;
					} else {
						return 1;
					}
				}
				return scoreDiff;
			}
		}).collect(Collectors.toList());
	}

	public void addResult(Result result) {
		results.add(result);
	}

	public Player getWinner() {
		return sortedResults().stream().findFirst().get().getPlayer();
	}

	@Override
	public String toString() {
		return "Tournament [venue=" + venue + ", date=" + date + ", name=" + name + ", results=" + results + "]";
	}

}
