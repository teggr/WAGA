package org.waga.player;

public enum Players {

	brad(Player.with("Brad", "Le Riche", 28, "").setCurrent()),
	teggy(Player.with("Robin", "Tegg", 15, "").setCurrent()),
	sturdy(Player.with("Richard", "Sturdy", 15, "").setCurrent()),
	snakes(Player.with("David", "Tryhorn", 24, "").setCurrent()),
	east(Player.with("Andrew", "Easter", 18, "").setCurrent()),
	damo(Player.with("Damien", "Kiernander", 18, "")),
	foist(Player.with("Richard", "Foister", 14, "").setCurrent()),
	henso(Player.with("Jon", "Henson", 28, "")),
	shifty(Player.with("Mark", "Shifty", 20, "")),
	kempo(Player.with("Nick", "Kemp", 28, "")),
	mitchell(Player.with("Andrew", "Mitchell", 28, "")),
	mac(Player.with("Ian", "MacDonald", 28, "")),
	greg(Player.with("Greg", "Williams", 28, "")),
	flaps(Player.with("Vien", "Phan", 28, "")),
	richg(Player.with("Rich", "Goulden", 28, "")),
	oshea(Player.with("Tim", "O'Shea", 12, "")),
	putts(Player.with("Alisdair", "Putt", 28, "")),
	coco(Player.with("Michael", "Coe", 28, "")),
	harry(Player.with("Harry", "Bridge", 12, "")),
	gav(Player.with("Gavin", "Reid", 28, "")),
	denno(Player.with("Christian", "Dennison", 28, "")),
	ego(Player.with("Bryan", "Egan", 24, "")),
	mannix(Player.with("James", "Mannix", 28, "")),
	dan(Player.with("Dan", "Kindell", 24, "")),
	steve(Player.with("Steve", "Madden", 15, "")),
	neil(Player.with("Neil", "Day", 18, "")),
	sean(Player.with("Sean", "Casey", 24, "")),
	apps(Player.with("Tom", "Apperley", 12, "").setCurrent()),
	maddog(Player.with("Andrew", "Stevens", 28, "").setCurrent());

	private Player player;

	private Players(Player player) {
		this.player = player;
	}

	public Player asPlayer() {
		return player;
	}

}
