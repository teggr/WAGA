package org.waga.player;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.waga.core.AbstractEntity;

@Entity
public class Player extends AbstractEntity {

	private String firstName;
	private String surname;
	private int currentHandicap;
	@Temporal(TemporalType.TIMESTAMP)
	private Date handicapDate;
	private String imageUrl;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "player")
	private Set<HistoricHandicap> handicapHistory;

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

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
		if(handicapDate==null) {
			handicapDate = new Date();
		}
	}

	public Set<HistoricHandicap> getHandicapHistory() {
		if (handicapHistory == null) {
			handicapHistory = new HashSet<>();
		}
		return handicapHistory;
	}

	public String getFullName() {
		return firstName + " " + surname;
	}

	public void update(Player player) {
		this.firstName = player.firstName;
		this.surname = player.surname;
		if (this.currentHandicap != player.currentHandicap) {
			auditHandicap();
			this.currentHandicap = player.currentHandicap;
			this.handicapDate = new Date();
		}
		this.imageUrl = player.imageUrl;
	}

	private void auditHandicap() {
		HistoricHandicap current = new HistoricHandicap();
		current.setExpiredDate(handicapDate);
		current.setHandicap(currentHandicap);
		current.setPlayer(this);
		handicapHistory.add(current);
	}

	public HistoricHandicaps getLast10Handicaps() {
		List<HistoricHandicap> historic = new ArrayList<>(handicapHistory).stream()
				.sorted(HistoricHandicap.REVERSE_DATE_ORDER).limit(9).collect(Collectors.toList());
		HistoricHandicap current = new HistoricHandicap();
		current.setExpiredDate(new Date());
		current.setHandicap(currentHandicap);
		historic.add(current);
		return new HistoricHandicaps(historic);
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", surname=" + surname + ", currentHandicap=" + currentHandicap
				+ ", handicapDate=" + handicapDate + ", imageUrl=" + imageUrl + ", handicapHistory=" + handicapHistory
				+ "]";
	}

}
