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

public class ManorOfGroves extends WoodmanCupEventDataProvider {

	static void manorofgroves(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("GUNT", "Blue", Players.greg);
		addPlayer(team1, Players.apps);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.east);
		addPlayer(team1, Players.greg);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.mannix);

		Team team2 = Team.newInstance("Bare naked henso's hensoes", "Yellow", Players.henso);
		addPlayer(team2, Players.sturdy);
		addPlayer(team2, Players.brad);
		addPlayer(team2, Players.teggy);
		addPlayer(team2, Players.henso);
		addPlayer(team2, Players.coco);
		addPlayer(team2, Players.foist);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.manorofgroves.asVenue(), Utils.asDate("2012-10-16"),
				team1, team2);
		wc.setPuttOffWinner(Players.mannix);
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
		addMatch(new MatchBuilder().teamOf(Players.mannix).beat(Players.teggy), list);
		addMatch(new MatchBuilder().teamOf(Players.east).lostTo(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).lostTo(Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.greg).lostTo(Players.coco), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog).beat(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).beat(Players.brad), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.mannix, Players.greg).beat(Players.teggy, Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.east, Players.snakes).beat(Players.sturdy, Players.coco), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.maddog).lostTo(Players.foist, Players.brad), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.snakes, Players.apps).beat(Players.brad, Players.teggy), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog, Players.mannix).drewWith(Players.sturdy, Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.east, Players.greg).beat(Players.henso, Players.coco), list);
		return list;
	}

}
