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

public class Belfry2018 extends WoodmanCupEventDataProvider {

	@Override
	public void registerEvent(List<WoodmanCupEvent> list) {

		Team team1 = Team.newInstanceAsWinner("Team Fashion", "Red", Players.apps);
		addPlayer(team1, Players.snakes);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.apps);
		addPlayer(team1, Players.pat);

		Team team2 = Team.newInstance("Team Function (aka Team Mental Implosion)", "Blue", Players.east);
		addPlayer(team2, Players.foist);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.maddog);
		addPlayer(team2, Players.brad);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.belfry.asVenue(), Utils.asDate("2018-09-21"), team1,
				team2);
		session(Session.Type.FRIDAY, Session.Format.TEAM, session1Matches(), wc);
		session(Session.Type.SATURDAY, Session.Format.PAIRS, session2Matches(), wc);
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
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).beat(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.pat).beat(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).drewWith(Players.foist), list);
		// back 9
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.apps).lostTo(Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.pat).beat(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).lostTo(Players.east), list);
		return list;
	}

	private List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		// front 9
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.pat).lostTo(Players.foist, Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.snakes).lostTo(Players.east, Players.maddog), list);
		// back 9
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.pat).lostTo(Players.foist, Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.apps, Players.snakes).drewWith(Players.east, Players.maddog), list);
		return list;
	}

	private List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.apps, Players.pat, Players.snakes).beat(Players.foist,
				Players.east, Players.brad, Players.maddog), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.apps, Players.pat, Players.snakes)
				.drewWith(Players.foist, Players.east, Players.brad, Players.maddog), list);
		return list;
	}

}
