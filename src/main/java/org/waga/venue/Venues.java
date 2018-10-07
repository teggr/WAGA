package org.waga.venue;

public enum Venues {

	oldthorns(Venue.with("Old Thorns Manor Hotel", "http://www.oldthorns.com/", 
			"/images/oldthorns.jpg")),
	sedlescombe(Venue.with("Sedlescombe Golf Club", "http://www.sedlescombegolfclub.co.uk/", 
			"/images/seldescombe.jpg")),
	staverton(Venue.with("Staverton Park Golf Course", "http://www.devere.co.uk/our-locations/staverton-park/golf.html",
			"/images/staverton.jpg")),
	oxfordshire(Venue.with("The Oxfordshire", "https://www.theoxfordshire.com/", 
			"/images/oxfordshire.jpg")),
	belfry(Venue.with("The Belfry", "http://www.thebelfry.co.uk/", 
			"/images/belfry.jpg")),
	essexgc(Venue.with("The Essex Golf & Country Club", "http://www.theessexgolfandcountryclub.com/", 
			"/images/essexgc.jpg")),
	manorofgroves(Venue.with("Manor of Groves", "http://www.manorofgroves.com/", 
			"/images/manorofgroves.jpg")),
	donnington(Venue.with("Donnington Grove Country Club", "http://www.donnington-grove.com/", 
			"/images/donnington.jpg")),
	abbotsley(Venue.with("Abbotsley Golf Hotel", "http://www.abbotsley.com/pages.php/index.html", 
			"/images/abbotsley.jpg")),
	dorset(Venue.with("The Dorset Golf And Country Club", "http://www.dorsetgolfresort.com/", 
			"/images/old-thorns.jpg")),
	bidford(Venue.with("Bidford Grange", "http://www.bidfordgrange.com/", 
			"/images/dorset.jpg")),
	eastsussex(Venue.with("East Sussex National", "http://www.eastsussexnational.co.uk/",			
			"/images/eastsussex.jpg")),
	princes(Venue.with("Princes", "https://www.princesgolfclub.co.uk/", 
			"/images/princes.jpg"));

	private Venue venue;

	private Venues(Venue venue) {
		this.venue = venue;
	}

	public Venue asVenue() {
		return venue;
	}
}
