package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

import com.woodmancup.tournaments.Match.MatchBuilder;
import com.woodmancup.tournaments.Session.Format;
import com.woodmancup.tournaments.Session.Type;

public class Staverton extends WoodmanCupEventDataProvider {

	static void staverton(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstance("Pink Shirts And Cts", "Pink", Players.foist);
		addPlayer(team1, Players.apps);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.greg);
		addPlayer(team1, Players.putts);
		addPlayer(team1, Players.gav);
		addPlayer(team1, Players.foist);

		Team team2 = Team.newInstanceAsWinner("Gentle Ben Bear Society Cts", "Orange", Players.brad);
		addPlayer(team2, Players.sturdy);
		addPlayer(team2, Players.brad);
		addPlayer(team2, Players.teggy);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.henso);
		addPlayer(team2, Players.maddog);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.staverton.asVenue(), Utils.asDate("2011-09-16"), team1,
				team2);
		wc.setPuttOffWinner(Players.maddog);
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
		addMatch(new MatchBuilder().teamOf(Players.foist).drewWith(Players.sturdy,Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).beat(Players.teggy), list);
		addMatch(new MatchBuilder().teamOf(Players.greg).beat(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).lostTo(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.gav).drewWith(Players.maddog), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.snakes).beat(Players.brad, Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.putts, Players.greg).lostTo(Players.teggy, Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.foist, Players.snakes).lostTo(Players.sturdy, Players.maddog), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.snakes, Players.apps).beat(Players.brad, Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.gav, Players.putts).lostTo(Players.sturdy, Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.foist).drewWith(Players.teggy, Players.east), list);
		return list;
	}

}
