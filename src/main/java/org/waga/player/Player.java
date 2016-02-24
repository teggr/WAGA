package org.waga.player;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.util.StringUtils;
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

	@Embedded
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

	public void updateFrom(Player player) {
		this.firstName = player.firstName;
		this.surname = player.surname;
		updateHandicap(player.currentHandicap);
		this.imageUrl = player.imageUrl;
		if (player.emailAddress != null && !StringUtils.isEmpty(player.emailAddress.getAddress())) {
			this.emailAddress = player.getEmailAddress();
		}
	}

	private void updateHandicap(int handicap) {
		if(this.currentHandicap!=handicap) {
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

	public static Player with(Player player) {
		Player newPlayer = new Player();
		newPlayer.updateFrom(player);
		return newPlayer;
	}

}
