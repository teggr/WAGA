package org.waga.player;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerProfile  {
	
	public static PlayerProfile with(String firstName, String surname, int currentHandicap, String imageUrl) {
		PlayerProfile player = new PlayerProfile();
		player.firstName = firstName;
		player.surname = surname;
		player.currentHandicap = currentHandicap;
		player.imageUrl = imageUrl;
		return player;
	}

	private String firstName;
	private String surname;
	private int currentHandicap;
	private Date handicapDate;
	private String imageUrl;
	private Date lastAppearance = new java.sql.Date(0);
	
	public void recordAppearance(Date appearanceDate) {
		this.lastAppearance = appearanceDate;
	}
	
	public Date getLastAppearance() {
		return lastAppearance;
	}

	private Set<HistoricHandicap> handicapHistory;

	private EmailAddress emailAddress;

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public int getCurrentHandicap() {
		return currentHandicap;
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

	private void updateHandicap(int handicap) {
		if (this.currentHandicap != handicap) {
			auditHandicap();
			this.currentHandicap = handicap;
			this.handicapDate = new Date();
		}
	}

	private void auditHandicap() {
		if (handicapDate != null) {
			HistoricHandicap current = new HistoricHandicap();
			current.setExpiredDate(handicapDate);
			current.setHandicap(currentHandicap);
			current.setPlayer(this);
			handicapHistory.add(current);
		}
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

}
