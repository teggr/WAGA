package org.waga.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;
import org.waga.woodmancup.Match;
import org.waga.woodmancup.Session;
import org.waga.woodmancup.Team;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.WoodmanCupEventDataProvider;
import org.waga.woodmancup.Match.MatchBuilder;
import org.waga.woodmancup.Session.Format;
import org.waga.woodmancup.Session.Type;

public class Dorset extends WoodmanCupEventDataProvider {

	static void dorset(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstance("Team Scuzz", "Yellow", Players.apps);
		addPlayer(team1, Players.apps);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.east);
		addPlayer(team1, Players.henso);
		addPlayer(team1, Players.greg);
		addPlayer(team1, Players.flaps);

		Team team2 = Team.newInstanceAsWinner("Team 2", "Beige", Players.sturdy);
		addPlayer(team2, Players.sturdy);
		addPlayer(team2, Players.brad);
		addPlayer(team2, Players.teggy);
		addPlayer(team2, Players.mitchell);
		addPlayer(team2, Players.mac);
		addPlayer(team2, Players.maddog);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.dorset.asVenue(), Utils.asDate("2006-09-16"), team1,
				team2);
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
		addMatch(new MatchBuilder().teamOf(Players.flaps).lostTo(Players.teggy), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).lostTo(Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.east).beat(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).lostTo(Players.mac), list);
		addMatch(new MatchBuilder().teamOf(Players.mitchell).drewWith(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.greg).lostTo(Players.brad), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.flaps).drewWith(Players.teggy, Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.east, Players.snakes).beat(Players.mac, Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.henso, Players.greg).lostTo(Players.sturdy, Players.mitchell), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.snakes, Players.apps).lostTo(Players.teggy, Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.east, Players.henso).beat(Players.brad, Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.flaps, Players.greg).lostTo(Players.sturdy, Players.mac), list);
		return list;
	}

}
