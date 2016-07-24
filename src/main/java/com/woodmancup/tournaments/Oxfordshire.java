package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Oxfordshire extends WoodmanCupEventDataProvider {

	static void oxfordshire(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("team1", "cycling", Players.snakes.asPlayer());
		addPlayer(team1, Players.sturdy.asPlayer());
		addPlayer(team1, Players.east.asPlayer());
		addPlayer(team1, Players.brad.asPlayer());
		addPlayer(team1, Players.apps.asPlayer());

		Team team2 = Team.newInstance("team2", "brown", Players.sturdy.asPlayer());
		addPlayer(team2, Players.teggy.asPlayer());
		addPlayer(team2, Players.maddog.asPlayer());
		addPlayer(team2, Players.snakes.asPlayer());
		addPlayer(team2, Players.foist.asPlayer());

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.oxfordshire.asVenue(), Utils.asDate("2015-09-16"),
				team1, team2);
		list.add(wc);
	}

}
