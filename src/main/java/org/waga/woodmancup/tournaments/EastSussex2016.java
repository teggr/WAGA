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

public class EastSussex2016 extends WoodmanCupEventDataProvider {

	@Override
	public void registerEvent(List<WoodmanCupEvent> list) {

		Team team1 = Team.newInstanceAsWinner("T'Apperley it in", "Various", Players.apps);
		addPlayer(team1, Players.sturdy);
		addPlayer(team1, Players.east);
		addPlayer(team1, Players.brad);
		addPlayer(team1, Players.apps);

		Team team2 = Team.newInstance("Foist on the Tyne", "Black", Players.foist);
		addPlayer(team2, Players.foist);
		addPlayer(team2, Players.teggy);
		addPlayer(team2, Players.maddog);
		addPlayer(team2, Players.snakes);

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.eastsussex.asVenue(), Utils.asDate("2016-09-02"), team1,
				team2);
		session(Session.Type.FRIDAY, Session.Format.PAIRS, session1Matches(), wc);
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
		addMatch(new MatchBuilder().teamOf(Players.maddog).beat(Players.brad), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes).beat(Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.foist).drewWith(Players.apps), list);
		addMatch(new MatchBuilder().teamOf(Players.teggy).lostTo(Players.east), list);
		return list;
	}

	private List<Match> session2Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.snakes).lostTo(Players.apps, Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.maddog, Players.foist).lostTo(Players.east, Players.brad), list);
		return list;
	}

	private List<Match> session1Matches() {
		List<Match> list = new ArrayList<>();
		addMatch(new MatchBuilder().teamOf(Players.teggy, Players.maddog).lostTo(Players.east, Players.sturdy), list);
		addMatch(new MatchBuilder().teamOf(Players.snakes, Players.foist).lostTo(Players.apps, Players.brad), list);
		return list;
	}
}
