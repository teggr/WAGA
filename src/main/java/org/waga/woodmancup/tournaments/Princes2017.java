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

public class Princes2017 extends WoodmanCupEventDataProvider {

	@Override
	public void registerEvent(List<WoodmanCupEvent> list) {

		Team team1 = Team.newInstanceAsWinner("Snakes", "Various", Players.snakes);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.east);
		addPlayer(team1, Players.ghost);

		Team team2 = Team.newInstance("Mad", "Black", Players.maddog);
		addPlayer(team2, Players.foist);
		addPlayer(team2, Players.apps);
		addPlayer(team2, Players.maddog);
		addPlayer(team2, Players.brad);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.princes.asVenue(), Utils.asDate("2017-09-02"), team1,
				team2);
		session(Session.Type.FRIDAY, Session.Format.PAIRS, session1Matches(), wc);
		session(Session.Type.SATURDAY, Session.Format.TEAM, session2Matches(), wc);
		session(Session.Type.SUNDAY, Session.Format.SINGLES, session3Matches(), wc);
		list.add(wc);
	}

	private void session(Type type, Format format, List<Match> matches, WoodmanCupEvent wc) {
		Session session = new Session(type, format);
		session.addMatches(matches);
		wc.addSession(session);
	}

	private List<Match> session3Matches() {
		List<Match> list = new ArrayList<>();
		// front 9
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).lostTo(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.east).drewWith(Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.ghost).beat(Players.foist), list);
		// back 9
		addMatch(new MatchBuilder().teamOf(Players.snakes).beat(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.east).beat(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.ghost).beat(Players.apps), list);
		return list;
	}

	private List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.snakes, Players.east).lostTo(Players.apps,
				Players.foist, Players.brad, Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.snakes, Players.east).lostTo(Players.apps,
				Players.foist, Players.brad, Players.maddog), list);
		return list;
	}

	private List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.maddog, Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes, Players.east).lostTo(Players.apps, Players.foist), list);
		return list;
	}
	
}
