package org.waga.player;

import org.waga.core.Utils;

public enum Players {

	brad(Player.with("Brad", "Le Riche", 28, "https://lh3.googleusercontent.com/-_7B_KW4ujZA/UWkerw3QatI/AAAAAAAAAcg/hSLGN7wG1i8/s576-Ic42/IMG_1352.JPG", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	teggy(Player.with("Robin", "Tegg", 15, "https://lh3.googleusercontent.com/-KHD2FqSTSzE/UWkfS9XySWI/AAAAAAAAAhk/lrutIDF0JUE/s576-Ic42/IMG_1394.JPG", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	sturdy(Player.with("Richard", "Sturdy", 15, "", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	snakes(Player.with("David", "Tryhorn", 24, "https://lh3.googleusercontent.com/-zt1rxh0JC8M/UWkfZLuKKiI/AAAAAAAAAik/P3Y4AYvQon0/s576-Ic42/IMG_1402.JPG", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	east(Player.with("Andrew", "Easter", 18, "", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	damo(Player.with("Damien", "Kiernander", 18, "https://lh3.googleusercontent.com/-8mqF4e6Nt_4/UWk9Joc6v2I/AAAAAAAABsQ/W2hxoAg8N1o/s576-Ic42/IMG_0463.jpg", Utils.DEFAULT_JOIN_DATE)),
	foist(Player.with("Richard", "Foister", 14, "https://lh3.googleusercontent.com/-U8_-o4YKq2Y/UWkget1RoYI/AAAAAAAAArQ/Lr2KxUUi4Iw/s576-Ic42/IMG_1434.JPG", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	henso(Player.with("Jon", "Henson", 28, "", Utils.DEFAULT_JOIN_DATE)),
	shifty(Player.with("Mark", "Shifty", 20, "", Utils.DEFAULT_JOIN_DATE)),
	kempo(Player.with("Nick", "Kemp", 28, "", Utils.DEFAULT_JOIN_DATE)),
	mitchell(Player.with("Andrew", "Mitchell", 28, "", Utils.DEFAULT_JOIN_DATE)),
	mac(Player.with("Ian", "MacDonald", 28, "", Utils.DEFAULT_JOIN_DATE)),
	greg(Player.with("Greg", "Williams", 28, "", Utils.DEFAULT_JOIN_DATE)),
	flaps(Player.with("Vien", "Phan", 28, "", Utils.DEFAULT_JOIN_DATE)),
	richg(Player.with("Rich", "Goulden", 28, "", Utils.DEFAULT_JOIN_DATE)),
	oshea(Player.with("Tim", "O'Shea", 12, "", Utils.DEFAULT_JOIN_DATE)),
	putts(Player.with("Alisdair", "Putt", 28, "", Utils.DEFAULT_JOIN_DATE)),
	coco(Player.with("Michael", "Coe", 28, "", Utils.DEFAULT_JOIN_DATE)),
	harry(Player.with("Harry", "Bridge", 12, "", Utils.DEFAULT_JOIN_DATE)),
	gav(Player.with("Gavin", "Reid", 28, "", Utils.DEFAULT_JOIN_DATE)),
	denno(Player.with("Christian", "Dennison", 28, "", Utils.DEFAULT_JOIN_DATE)),
	ego(Player.with("Bryan", "Egan", 24, "", Utils.DEFAULT_JOIN_DATE)),
	mannix(Player.with("James", "Mannix", 28, "", Utils.DEFAULT_JOIN_DATE)),
	dan(Player.with("Dan", "Kindell", 24, "", Utils.DEFAULT_JOIN_DATE)),
	steve(Player.with("Steve", "Orford", 15, "", Utils.DEFAULT_JOIN_DATE)),
	neil(Player.with("Neil", "Day", 18, "", Utils.DEFAULT_JOIN_DATE)),
	sean(Player.with("Sean", "Casey", 24, "", Utils.DEFAULT_JOIN_DATE)),
	apps(Player.with("Tom", "Apperley", 12, "https://lh3.googleusercontent.com/-cIxQxa_T_BI/UWkfQFOlMhI/AAAAAAAAAhM/I2wHR43asoY/s576-Ic42/IMG_1390.JPG", Utils.DEFAULT_JOIN_DATE).setCurrent()),
	maddog(Player.with("Andrew", "Stevens", 28, "https://lh3.googleusercontent.com/-mkb9kUZnWLk/UWkfiEjatDI/AAAAAAAAAkU/AHuCaLLq6Jk/s576-Ic42/IMG_1416.JPG	", Utils.DEFAULT_JOIN_DATE).setCurrent());

	private Player player;

	private Players(Player player) {
		this.player = player;
	}

	public Player asPlayer() {
		return player;
	}

}
