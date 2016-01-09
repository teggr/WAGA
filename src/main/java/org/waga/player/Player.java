package org.waga.player;

import javax.persistence.Entity;

import org.waga.core.AbstractEntity;

@Entity
public class Player extends AbstractEntity {

	private String firstName;
	private String surname;
	private int currentHandicap;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getCurrentHandicap() {
		return currentHandicap;
	}

	public void setCurrentHandicap(int currentHandicap) {
		this.currentHandicap = currentHandicap;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", surname=" + surname + ", currentHandicap=" + currentHandicap + "]";
	}

	public String getFullName() {
		return firstName + " " + surname;
	}

	public void update(Player player) {
		this.firstName = player.firstName;
		this.surname = player.surname;
		this.currentHandicap = player.currentHandicap;
	}

}
