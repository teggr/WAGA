package org.waga.venue;

public class Venue {

	public static Venue with(String name, String link, String googleMapLink, String imageUrl) {
		Venue venue = new Venue();
		venue.name = name;
		venue.link = link;
		venue.googleMapLink = googleMapLink;
		venue.imageUrl = imageUrl;
		return venue;
	}

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

}
