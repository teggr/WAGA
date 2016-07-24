package org.waga.open;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.waga.player.Player;
import org.waga.venue.Venue;

public class OpenChallengeEvent {

	private Venue venue;
	private Date date;
	private List<Result> results = new ArrayList<>();

	public OpenChallengeEvent(Venue venue, Date eventDate) {
		this.venue = venue;
		this.date = eventDate;
	}

	public Date getDate() {
		return date;
	}

	public Venue getVenue() {
		return venue;
	}

	public void addResult(Player player, int points) {
		results.add(new Result(player, points));
	}
	
	public List<Result> getResults() {
		return results;
	}

}
