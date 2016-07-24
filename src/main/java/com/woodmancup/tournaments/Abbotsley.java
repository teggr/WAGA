package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

import com.woodmancup.tournaments.Match.MatchBuilder;
import com.woodmancup.tournaments.Session.Format;
import com.woodmancup.tournaments.Session.Type;

public class Abbotsley extends WoodmanCupEventDataProvider {

	static void abbotsley(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("The Neapolitans", "Chocolate Brown", Players.teggy);
		addPlayer(team1, Players.sturdy);
		addPlayer(team1, Players.brad);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.greg);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.harry);
		addPlayer(team1, Players.denno);
		addPlayer(team1, Players.ego);

		Team team2 = Team.newInstance("Chalice Of Banter", "Burnt Orange", Players.snakes);
		addPlayer(team2, Players.apps);
		addPlayer(team2, Players.snakes);
		addPlayer(team2, Players.mitchell);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.henso);
		addPlayer(team2, Players.oshea);
		addPlayer(team2, Players.gav);
		addPlayer(team2, Players.damo);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.abbotsley.asVenue(), Utils.asDate("2007-09-16"), team1,
				team2);
		wc.setPuttOffWinner(Players.east);
		wc.setAlternativeWoodmanCupWinner(Players.denno);
		session(Session.Type.FRIDAY, Session.Format.PAIRS, session1Matches(), wc);
		session(Session.Type.SATURDAY, Session.Format.PAIRS, session2Matches(), wc);
		session(Session.Type.SUNDAY, Session.Format.SINGLES, session3Matches(), wc);
		list.add(wc);
	}

	private static void session(Type type, Format format, List<Match> matches, WoodmanCupEvent wc) {
		Session session = new Session(type, format);
		session.addMatches(matches);
		wc.addSession(session);
	}

	private static List<Match> session3Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.oshea), list);
		addMatch(new MatchBuilder().teamOf(Players.harry).beat(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy).lostTo(Players.damo), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog).lostTo(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.ego).beat(Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.greg).beat(Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.brad).beat(Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.denno).lostTo(Players.gav), list);
		return list;
	}

	private static List<Match> session2Matches() {		
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.denno).beat(Players.east, Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.ego).lostTo(Players.henso, Players.damo), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog, Players.brad).beat(Players.apps, Players.gav), list);
		addMatch(new MatchBuilder().teamOf(Players.harry, Players.greg).beat(Players.oshea, Players.mitchell), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.greg).beat(Players.oshea, Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.harry).beat(Players.east, Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.denno, Players.sturdy).lostTo(Players.damo, Players.gav), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog, Players.ego).lostTo(Players.apps, Players.snakes), list);
		return list;
	}

}
