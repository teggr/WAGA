package org.waga.player;

public enum Players {

	brad(PlayerProfile.with("Brad", "Le Riche", 28, "")),
	teggy(PlayerProfile.with("Robin", "Tegg", 15, "")),
	sturdy(PlayerProfile.with("Richard", "Sturdy", 15, "")),
	snakes(PlayerProfile.with("David", "Tryhorn", 24, "")),
	east(PlayerProfile.with("Andrew", "Easter", 18, "")),
	damo(PlayerProfile.with("Damien", "Kiernander", 18, "")),
	foist(PlayerProfile.with("Richard", "Foister", 14, "")),
	henso(PlayerProfile.with("Jon", "Henson", 28, "")),
	shifty(PlayerProfile.with("Mark", "Shifty", 20, "")),
	kempo(PlayerProfile.with("Nick", "Kemp", 28, "")),
	mitchell(PlayerProfile.with("Andrew", "Mitchell", 28, "")),
	mac(PlayerProfile.with("Ian", "MacDonald", 28, "")),
	greg(PlayerProfile.with("Greg", "Williams", 28, "")),
	flaps(PlayerProfile.with("Vien", "Phan", 28, "")),
	richg(PlayerProfile.with("Rich", "Goulden", 28, "")),
	oshea(PlayerProfile.with("Tim", "O'Shea", 12, "")),
	putts(PlayerProfile.with("Alisdair", "Putt", 28, "")),
	coco(PlayerProfile.with("Michael", "Coe", 28, "")),
	harry(PlayerProfile.with("Harry", "Bridge", 12, "")),
	gav(PlayerProfile.with("Gavin", "Reid", 28, "")),
	denno(PlayerProfile.with("Christian", "Dennison", 28, "")),
	ego(PlayerProfile.with("Bryan", "Egan", 24, "")),
	mannix(PlayerProfile.with("James", "Mannix", 28, "")),
	dan(PlayerProfile.with("Dan", "Kindell", 24, "")),
	steve(PlayerProfile.with("Steve", "Madden", 15, "")),
	neil(PlayerProfile.with("Neil", "Day", 18, "")),
	sean(PlayerProfile.with("Sean", "Casey", 24, "")),
	apps(PlayerProfile.with("Tom", "Apperley", 12, "")),
	maddog(PlayerProfile.with("Andrew", "Stevens", 28, ""));

	private PlayerProfile details;

	private Players(PlayerProfile p) {
		this.details = p;
	}

	public PlayerProfile getDetails() {
		return details;
	}

}
