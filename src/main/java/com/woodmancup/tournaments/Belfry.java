package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Belfry extends WoodmanCupEventDataProvider {

	static void belfry(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("#ciddysback", "Blue", Players.east.asPlayer());
		addPlayer(team1, Players.sturdy.asPlayer());
		addPlayer(team1, Players.teggy.asPlayer());
		addPlayer(team1, Players.east.asPlayer());
		addPlayer(team1, Players.snakes.asPlayer());
		
		Team team2 = Team.newInstance("Money Team", "Green", Players.apps.asPlayer());
		addPlayer(team2, Players.apps.asPlayer());
		addPlayer(team2, Players.foist.asPlayer());
		addPlayer(team2, Players.maddog.asPlayer());
		addPlayer(team2, Players.brad.asPlayer());
		
		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.belfry.asVenue(), Utils.asDate("2014-09-16"), team1,
				team2);
		list.add(wc);
	}

}
