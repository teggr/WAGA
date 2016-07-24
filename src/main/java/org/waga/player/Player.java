package org.waga.player;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {

	private static final int MAX_HANDICAP = 28;

	public static Player with(String firstName, String surname, int currentHandicap, String imageUrl) {
		Player player = new Player();
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
	private boolean current;

	public Player setCurrent() {
		current = true;
		return this;
	}

	public void recordAppearance(Date appearanceDate) {
		this.lastAppearance = appearanceDate;
	}

	public Date getLastAppearance() {
		return lastAppearance;
	}

	private Set<HistoricHandicap> handicapHistory = new HashSet<>();

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

	private void updateHandicap(int handicap, String message) {
		if (this.currentHandicap != handicap) {
			auditHandicap(message);
			this.currentHandicap = handicap;
			this.handicapDate = new Date();
		}
	}

	private void auditHandicap(String message) {
		if (handicapDate != null) {
			HistoricHandicap expiringHandicap = new HistoricHandicap();
			expiringHandicap.setExpiredDate(handicapDate);
			expiringHandicap.setHandicap(currentHandicap);
			expiringHandicap.setMessage(message);
			handicapHistory.add(expiringHandicap);
		}
	}

	public HistoricHandicaps getLast10Handicaps() {
		List<HistoricHandicap> historic = new ArrayList<>(getHandicapHistory()).stream()
				.sorted(HistoricHandicap.REVERSE_DATE_ORDER).limit(9).collect(Collectors.toList());
		HistoricHandicap current = new HistoricHandicap();
		current.setExpiredDate(new Date());
		current.setHandicap(currentHandicap);
		historic.add(current);
		return new HistoricHandicaps(historic);
	}

	public boolean isCurrent() {
		return current;
	}

	public void incrementHandicap(int increment, String message) {
		if (currentHandicap + increment <= MAX_HANDICAP) {
			updateHandicap(currentHandicap + increment, message);
		}
	}

	public void decrementHandicap(int decrement, String message) {
		updateHandicap(currentHandicap - decrement, message);
	}

	public List<String> getHandicapChangeMessages() {
		return new ArrayList<>(getHandicapHistory()).stream().sorted(HistoricHandicap.REVERSE_DATE_ORDER).limit(9)
				.map(h -> h.getHandicap() + " " + h.getMessage()).collect(Collectors.toList());
	}

}
