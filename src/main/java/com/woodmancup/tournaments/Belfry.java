package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

import com.woodmancup.tournaments.Match.MatchBuilder;
import com.woodmancup.tournaments.Session.Format;
import com.woodmancup.tournaments.Session.Type;

public class Belfry extends WoodmanCupEventDataProvider {

	static void belfry(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("#ciddysback", "Blue", Players.east);
		addPlayer(team1, Players.sturdy);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.east);
		addPlayer(team1, Players.snakes);

		Team team2 = Team.newInstance("Money Team", "Green", Players.apps);
		addPlayer(team2, Players.apps);
		addPlayer(team2, Players.foist);
		addPlayer(team2, Players.maddog);
		addPlayer(team2, Players.brad);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.belfry.asVenue(), Utils.asDate("2014-09-16"), team1,
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
		addMatch(new MatchBuilder().teamOf(Players.sturdy).beat(Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.east).lostTo(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).beat(Players.brad), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.snakes).beat(Players.foist, Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.east, Players.sturdy).beat(Players.maddog, Players.brad), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.snakes).drewWith(Players.brad, Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.east).beat(Players.foist, Players.maddog), list);
		return list;
	}

}
