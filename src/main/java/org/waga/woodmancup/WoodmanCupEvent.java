package org.waga.woodmancup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.venue.Venue;

public class WoodmanCupEvent {

	public static WoodmanCupEvent newInstance(Venue venue, Date date, Team team1, Team team2) {
		WoodmanCupEvent tournament = new WoodmanCupEvent();
		tournament.team1 = team1;
		tournament.team2 = team2;
		tournament.date = date;
		tournament.venue = venue;
		return tournament;
	}

	private Date date;
	private Venue venue;
	private Team team1;
	private Team team2;
	private List<Session> sessions = new ArrayList<>();
	private Player puttOffWinner;
	private Player alternativeWoodmanCupWinner;

	public boolean hasIndividualWinners() {
		return puttOffWinner != null || alternativeWoodmanCupWinner != null;
	}
	
	public double getTeamPoints(Team team) {
		double total = 0;
		for (Session session : sessions) {
			total = total + session.getTeamPoints(team);
		}
		return total;		
	}

	public void addSession(Session session) {
		sessions.add(session);
	}

	public Player getAlternativeWoodmanCupWinner() {
		return alternativeWoodmanCupWinner;
	}

	public Player getPuttOffWinner() {
		return puttOffWinner;
	}

	public Venue getVenue() {
		return venue;
	}

	public Date getDate() {
		return date;
	}

	public Team getTeam1() {
		return team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setPuttOffWinner(Players puttOffWinner) {
		this.puttOffWinner = puttOffWinner.asPlayer();
	}

	public void setAlternativeWoodmanCupWinner(Players alternativeWoodmanCupWinner) {
		this.alternativeWoodmanCupWinner = alternativeWoodmanCupWinner.asPlayer();
	}

	public boolean isYear(String year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (calendar.get(Calendar.YEAR) == Integer.parseInt(year)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean wasAttendedBy(Player player) {
		return team1.isPlayer(player) || team2.isPlayer(player);
	}

	public boolean inWinningTeam(Player player) {
		return getWinningTeam().isPlayer(player);
	}

	private Team getWinningTeam() {
		if (team1.isWinner()) {
			return team1;
		} else {
			return team2;
		}
	}
}
