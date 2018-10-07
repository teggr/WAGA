package org.waga.player;

public class Player {

	public static Player with(String firstName, String surname) {
		Player player = new Player();
		player.firstName = firstName;
		player.surname = surname;
		return player;
	}

	private String firstName;
	private String surname;

	private Player() {
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public String getFullName() {
		return String.format("%s %s", firstName, surname);
	}

}
