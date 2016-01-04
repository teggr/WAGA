package org.waga.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
