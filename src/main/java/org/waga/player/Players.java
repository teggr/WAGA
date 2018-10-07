package org.waga.player;

public enum Players {

	brad(Player.with("Brad", "Le Riche")),
	teggy(Player.with("Robin", "Tegg")),
	sturdy(Player.with("Richard", "Sturdy")),
	snakes(Player.with("David", "Tryhorn")),
	east(Player.with("Andrew", "Easter")),
	damo(Player.with("Damien", "Kiernander")),
	foist(Player.with("Richard", "Foister")),
	henso(Player.with("Jon", "Henson")),
	shifty(Player.with("Mark", "Shifty")),
	kempo(Player.with("Nick", "Kemp")),
	mitchell(Player.with("Andrew", "Mitchell")),
	mac(Player.with("Ian", "MacDonald")),
	greg(Player.with("Greg", "Williams")),
	flaps(Player.with("Vien", "Phan")),
	richg(Player.with("Rich", "Goulden")),
	oshea(Player.with("Tim", "O'Shea")),
	putts(Player.with("Alisdair", "Putt")),
	coco(Player.with("Michael", "Coe")),
	harry(Player.with("Harry", "Bridge")),
	gav(Player.with("Gavin", "Reid")),
	denno(Player.with("Christian", "Dennison")),
	ego(Player.with("Bryan", "Egan")),
	mannix(Player.with("James", "Mannix")),
	dan(Player.with("Dan", "Kindell")),
	steve(Player.with("Steve", "Orford")),
	neil(Player.with("Neil", "Stanley")),
	sean(Player.with("Sean", "Casey")),
	apps(Player.with("Tom", "Apperley")),
	maddog(Player.with("Andrew", "Stevens")),
	ghost(Player.with("Ghost", "(Ghost) Sturdy")),
	pat(Player.with("Patrick", "Duckworth"));

	private Player player;

	private Players(Player player) {
		this.player = player;
	}

	public Player asPlayer() {
		return player;
	}

}
