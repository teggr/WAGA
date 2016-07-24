package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Hastings extends WoodmanCupEventDataProvider {

	static void hastings(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("The Hoo-Yahs", "Royal Blue", Players.teggy.asPlayer());
		addPlayer(team1, Players.sturdy.asPlayer());
		addPlayer(team1, Players.brad.asPlayer());
		addPlayer(team1, Players.teggy.asPlayer());
		addPlayer(team1, Players.henso.asPlayer());
		addPlayer(team1, Players.maddog.asPlayer());
		addPlayer(team1, Players.damo.asPlayer());
		addPlayer(team1, Players.denno.asPlayer());
		addPlayer(team1, Players.ego.asPlayer());

		Team team2 = Team.newInstance("Whoooooooaaah-(M)utiny on the Bounty", "Fire Engine Red",
				Players.east.asPlayer());
		addPlayer(team2, Players.apps.asPlayer());
		addPlayer(team2, Players.snakes.asPlayer());
		addPlayer(team2, Players.mitchell.asPlayer());
		addPlayer(team2, Players.east.asPlayer());
		addPlayer(team2, Players.greg.asPlayer());
		addPlayer(team2, Players.richg.asPlayer());
		addPlayer(team2, Players.gav.asPlayer());
		addPlayer(team2, Players.foist.asPlayer());

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.sedlescombe.asVenue(), Utils.asDate("2008-09-16"),
				team1, team2);
		wc.setPuttOffWinner(Players.east.asPlayer());
		list.add(wc);
	}

}
