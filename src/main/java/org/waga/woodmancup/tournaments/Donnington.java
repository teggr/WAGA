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

public class Donnington extends WoodmanCupEventDataProvider {

	static void donnington(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstance("Prince Of Snakes", "Lime Green", Players.snakes);
		addPlayer(team1, Players.sturdy);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.henso);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.ego);
		addPlayer(team1, Players.foist);

		Team team2 = Team.newInstanceAsWinner("Sinn Fein In The Membrane", "Lilac", Players.ego);
		addPlayer(team2, Players.apps);
		addPlayer(team2, Players.brad);
		addPlayer(team2, Players.mitchell);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.greg);
		addPlayer(team2, Players.richg);
		addPlayer(team2, Players.gav);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.donnington.asVenue(), Utils.asDate("2009-09-16"), team1,
				team2);
		wc.setPuttOffWinner(Players.brad);
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
		addMatch(new MatchBuilder().teamOf(Players.ego).lostTo(Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players. brad).lostTo(Players.gav), list);
		addMatch(new MatchBuilder().teamOf(Players.greg).lostTo(Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.mitchell).beat(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.richg).beat(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.apps,Players.east).beat(Players.foist,Players.teggy), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.apps).lostTo(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.mitchell, Players.east).beat(Players.sturdy, Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.greg, Players.ego).beat(Players.snakes, Players.teggy), list);
		addMatch(new MatchBuilder().teamOf(Players.richg, Players.brad).beat(Players.gav, Players.maddog), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.east).beat(Players.teggy), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.greg).beat(Players.gav, Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.ego).beat(Players.henso, Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.maddog).lostTo(Players.mitchell, Players.richg), list);
		return list;
	}

}
