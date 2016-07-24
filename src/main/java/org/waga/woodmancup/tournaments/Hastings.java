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

public class Hastings extends WoodmanCupEventDataProvider {

	static void hastings(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("The Hoo-Yahs", "Royal Blue", Players.teggy);
		addPlayer(team1, Players.sturdy);
		addPlayer(team1, Players.brad);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.henso);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.damo);
		addPlayer(team1, Players.denno);
		addPlayer(team1, Players.ego);

		Team team2 = Team.newInstance("Whoooooooaaah-(M)utiny on the Bounty", "Fire Engine Red",
				Players.east);
		addPlayer(team2, Players.apps);
		addPlayer(team2, Players.snakes);
		addPlayer(team2, Players.mitchell);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.greg);
		addPlayer(team2, Players.richg);
		addPlayer(team2, Players.gav);
		addPlayer(team2, Players.foist);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.sedlescombe.asVenue(), Utils.asDate("2008-09-16"),
				team1, team2);
		wc.setPuttOffWinner(Players.east);
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
		addMatch(new MatchBuilder().teamOf(Players.ego).beat(Players.richg), list);
		addMatch(new MatchBuilder().teamOf(Players.henso).lostTo(Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog).beat(Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.damo).beat(Players.gav), list);
		addMatch(new MatchBuilder().teamOf(Players.foist).beat(Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.brad).lostTo(Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.denno).lostTo(Players.greg), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.denno).lostTo(Players.foist, Players.greg), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.maddog).beat(Players.snakes, Players.gav), list);
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.damo).beat(Players.east, Players.mitchell), list);
		addMatch(new MatchBuilder().teamOf(Players.henso, Players.ego).lostTo(Players.apps, Players.richg), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.maddog).lostTo(Players.gav, Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.henso).beat(Players.east, Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.denno, Players.ego).beat(Players.greg, Players.richg), list);
		addMatch(new MatchBuilder().teamOf(Players.foist, Players.sturdy).lostTo(Players.damo, Players.mitchell), list);
		return list;
	}

}
