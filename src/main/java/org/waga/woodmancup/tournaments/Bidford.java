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

public class Bidford extends WoodmanCupEventDataProvider {

	static void bidford(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("The Gash", "Pink", Players.sturdy);
		addPlayer(team1, Players.apps);
		addPlayer(team1, Players.sturdy);
		addPlayer(team1, Players.shifty);
		addPlayer(team1, Players.kempo);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.brad);

		Team team2 = Team.newInstance("The Sex Panthers", "Black", Players.east);
		addPlayer(team2, Players.teggy);
		addPlayer(team2, Players.mitchell);
		addPlayer(team2, Players.mac);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.henso);
		addPlayer(team2, Players.greg);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.bidford.asVenue(), Utils.asDate("2005-09-16"), team1,
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
		addMatch(new MatchBuilder().teamOf(Players.apps).beat(Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy).beat(Players.mac), list);
		addMatch(new MatchBuilder().teamOf(Players.shifty).lostTo(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.kempo).lostTo(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).beat(Players.greg), list);
		addMatch(new MatchBuilder().teamOf(Players.brad).drewWith(Players.teggy), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.kempo).beat(Players.teggy, Players.greg), list);
		addMatch(new MatchBuilder().teamOf(Players.shifty, Players.brad).lostTo(Players.east, Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.snakes).lostTo(Players.henso, Players.mac), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.apps).beat(Players.teggy, Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.shifty, Players.kempo).lostTo(Players.east, Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.snakes).beat(Players.greg, Players.mac), list);
		return list;
	}

}
