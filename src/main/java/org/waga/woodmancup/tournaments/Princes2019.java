package org.waga.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;
import org.waga.woodmancup.Match;
import org.waga.woodmancup.Match.MatchBuilder;
import org.waga.woodmancup.Session;
import org.waga.woodmancup.Session.Format;
import org.waga.woodmancup.Session.Type;
import org.waga.woodmancup.Team;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.WoodmanCupEventDataProvider;

public class Princes2019 extends WoodmanCupEventDataProvider {

	@Override
	public void registerEvent(List<WoodmanCupEvent> list) {

		Team team1 = Team.newInstanceAsWinner("Maddog's Mad Marxists", "Red", Players.maddog);
		addPlayer(team1, Players.maddog);
		addPlayer(team1, Players.teggy);
		addPlayer(team1, Players.brad);
		addPlayer(team1, Players.sturdy);

		Team team2 = Team.newInstance("The Blue Rinse", "Blue", Players.pat);
		addPlayer(team2, Players.foist);
		addPlayer(team2, Players.pat);
		addPlayer(team2, Players.east);
		addPlayer(team2, Players.snakes);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.princes.asVenue(), Utils.asDate("2019-07-19"), team1,
				team2);
		wc.setPuttOffWinner(Players.brad);
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
		// front
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog).lostTo(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.brad).beat(Players.pat), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy).drewWith(Players.snakes), list);
		// back 9
		addMatch(new MatchBuilder().teamOf(Players.teggy).beat(Players.east), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog).lostTo(Players.foist), list);
		addMatch(new MatchBuilder().teamOf(Players.brad).beat(Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.sturdy).beat(Players.pat), list);
		return list;
	}

	private List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.sturdy, Players.brad, Players.maddog)
				.beat(Players.foist, Players.east, Players.pat, Players.snakes), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.sturdy, Players.brad, Players.maddog)
				.beat(Players.foist, Players.east, Players.pat, Players.snakes), list);
		return list;
	}

	private List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		// front 9
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.sturdy).lostTo(Players.east, Players.pat), list);
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.maddog).beat(Players.foist, Players.snakes), list);
		// back 9
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.sturdy).drewWith(Players.east, Players.pat), list);
		addMatch(new MatchBuilder().teamOf(Players.brad, Players.maddog).drewWith(Players.foist, Players.snakes), list);
		return list;
	}

}
