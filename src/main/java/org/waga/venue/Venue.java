package org.waga.venue;

import javax.persistence.Entity;

import org.waga.core.AbstractEntity;

public class Venue {

	private String name;
	private String link;
	private String googleMapLink;
	private String imageUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGoogleMapLink() {
		return googleMapLink;
	}

	public void setGoogleMapLink(String googleMapLink) {
		this.googleMapLink = googleMapLink;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Venue [name=" + name + ", link=" + link + ", googleMapLink=" + googleMapLink + ", imageUrl=" + imageUrl
				+ "]";
	}

	public void update(Venue venue) {
		this.name = venue.name;
		this.link = venue.link;
		this.googleMapLink = venue.googleMapLink;
		this.imageUrl = venue.imageUrl;
	}

}
