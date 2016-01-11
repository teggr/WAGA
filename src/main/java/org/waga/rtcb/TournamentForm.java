package org.waga.rtcb;

import java.util.Date;

public class TournamentForm {

	private Long venueId;
	private String name;
	private Date date;

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TournamentForm [venueId=" + venueId + ", name=" + name + ", date=" + date + "]";
	}

	public void update(Tournament tour) {
		tour.setName(name);
		tour.setDate(date);
	}

}
