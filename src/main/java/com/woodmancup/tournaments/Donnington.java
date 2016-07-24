package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Donnington extends WoodmanCupEventDataProvider {

	static void donnington(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstance("Prince Of Snakes", "Lime Green", Players.snakes.asPlayer());
		addPlayer(team1, Players.sturdy.asPlayer());
		addPlayer(team1, Players.snakes.asPlayer());
		addPlayer(team1, Players.teggy.asPlayer());
		addPlayer(team1, Players.henso.asPlayer());
		addPlayer(team1, Players.maddog.asPlayer());
		addPlayer(team1, Players.ego.asPlayer());
		addPlayer(team1, Players.foist.asPlayer());
		
		Team team2 = Team.newInstanceAsWinner("Sinn Fein In The Membrane", "Lilac", Players.ego.asPlayer());
		addPlayer(team2, Players.apps.asPlayer());
		addPlayer(team2, Players.brad.asPlayer());
		addPlayer(team2, Players.mitchell.asPlayer());
		addPlayer(team2, Players.east.asPlayer());
		addPlayer(team2, Players.greg.asPlayer());
		addPlayer(team2, Players.richg.asPlayer());
		addPlayer(team2, Players.gav.asPlayer());
		
		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.donnington.asVenue(), Utils.asDate("2009-09-16"), team1, team2);
		wc.setPuttOffWinner(Players.brad.asPlayer());
		list.add(wc);
	}

}
