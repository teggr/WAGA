package org.waga.woodmancup;

import java.util.Date;
import java.util.List;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.venue.Venue;
import org.waga.woodmancup.members.Member;

public class WoodmanCupEvent {

	public static WoodmanCupEvent newInstance( Venue venue, Date date,
			Team team1, Team team2) {
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
	private List<Session> sessions;
	private Player puttOffWinner;
	private Player alternativeWoodmanCupWinner;
	
	public void addSession(Session session) {
		sessions.add(session);
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

	public boolean hasTeam(String teamId) {
		if (team1.getId().equals(teamId)) {
			return true;
		} else if (team2.getId().equals(teamId)) {
			return true;
		}
		return false;
	}

	public Team getTeam(String teamId) {
		if (team1.getId().equals(teamId)) {
			return team1;
		} else if (team2.getId().equals(teamId)) {
			return team2;
		}
		return null;
	}

	public double getTeam1Points() {
		return getTeamPoints(team1);
	}

	public double getTeam2Points() {
		return getTeamPoints(team2);
	}

	private double getTeamPoints(Team team) {
		double points = 0;
		for (Session session : sessions) {
			points += session.getTeamPoints(team.getId());
		}
		return points;
	}

	public void setPuttOffWinner(Players puttOffWinner) {
		this.puttOffWinner = puttOffWinner.asPlayer();
	}

	public void setAlternativeWoodmanCupWinner(Players alternativeWoodmanCupWinner) {
		this.alternativeWoodmanCupWinner = alternativeWoodmanCupWinner.asPlayer();
	}
}
