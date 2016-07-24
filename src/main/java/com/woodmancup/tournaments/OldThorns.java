package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

import com.woodmancup.tournaments.Match.MatchBuilder;
import com.woodmancup.tournaments.Session.Format;
import com.woodmancup.tournaments.Session.Type;

public class OldThorns extends WoodmanCupEventDataProvider {

	static void oldthorns(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("Da Dog Pound", "Pale Blue", Players.maddog);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.brad);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.henso);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.putts);
		addPlayer(team1, Players.coco);
		addPlayer(team1, Players.foist);

		Team team2 = Team.newInstance("The Top Guns", "Turquoise", Players.gav);
		addPlayer(team2, Players.apps);
		addPlayer(team2, Players.sturdy);
		addPlayer(team2, Players.mitchell);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.greg);
		addPlayer(team2, Players.richg);
		addPlayer(team2, Players.gav);
		addPlayer(team2, Players.denno);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.oldthorns.asVenue(), Utils.asDate("2010-09-16"), team1,
				team2);
		wc.setPuttOffWinner(Players.putts);
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
		addMatch(new MatchBuilder().teamOf(Players.gav,Players.sturdy).drewWith(Players.teggy, Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.east).beat(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.greg).beat(Players.putts), list);
		addMatch(new MatchBuilder().teamOf(Players.richg).beat(Players.henso), list);
		addMatch(new MatchBuilder().teamOf(Players.denno).lostTo(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).lostTo(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.mitchell).lostTo(Players.coco), list);
		return list;
	}

	private static List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.east, Players.gav).beat(Players.snakes, Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.mitchell).beat(Players.putts, Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.greg, Players.denno).lostTo(Players.coco, Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.richg).lostTo(Players.teggy, Players.henso), list);
		return list;
	}

	private static List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.gav, Players.apps).beat(Players.brad, Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.east, Players.richg).beat(Players.coco, Players.putts), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy, Players.denno).lostTo(Players.henso, Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.greg, Players.mitchell).lostTo(Players.maddog, Players.teggy), list);
		return list;
	}

}
