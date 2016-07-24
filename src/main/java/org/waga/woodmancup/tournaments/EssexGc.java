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

public class EssexGc extends WoodmanCupEventDataProvider {

	static void essecgc(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("Head Up The Snakes", "Blue", Players.snakes);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.dan);
		addPlayer(team1, Players.foist);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.apps);

		Team team2 = Team.newInstance("Y+M=19", "Yellow", Players.brad);
		addPlayer(team2, Players.brad);
		addPlayer(team2, Players.sturdy);
		addPlayer(team2, Players.steve);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.neil);
		addPlayer(team2, Players.sean);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.essexgc.asVenue(), Utils.asDate("2013-09-16"), team1,
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
		addMatch(new MatchBuilder().teamOf(Players.snakes).drewWith(Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.dan).lostTo(Players.neil), list);
		addMatch(new MatchBuilder().teamOf(Players.foist).beat(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).beat(Players.steve), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog).beat(Players.sean), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.foist, Players.dan).beat(Players.brad, Players.neil), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes, Players.teggy).beat(Players.sturdy, Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.maddog).beat(Players.sean, Players.steve), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.dan).drewWith(Players.sturdy, Players.steve), list);
		addMatch(new MatchBuilder().teamOf(Players.foist, Players.maddog).lostTo(Players.east, Players.neil), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.snakes).beat(Players.sean, Players.brad), list);
		return list;
	}

}
