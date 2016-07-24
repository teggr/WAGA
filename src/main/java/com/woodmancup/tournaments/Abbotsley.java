package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Abbotsley extends WoodmanCupEventDataProvider {

	static void abbotsley(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("The Neapolitans", "Chocolate Brown", Players.teggy.asPlayer());
		addPlayer(team1, Players.sturdy.asPlayer());
		addPlayer(team1, Players.brad.asPlayer());
		addPlayer(team1, Players.teggy.asPlayer());
		addPlayer(team1, Players.greg.asPlayer());
		addPlayer(team1, Players.maddog.asPlayer());
		addPlayer(team1, Players.harry.asPlayer());
		addPlayer(team1, Players.denno.asPlayer());
		addPlayer(team1, Players.ego.asPlayer());

		Team team2 = Team.newInstance("Chalice Of Banter", "Burnt Orange", Players.snakes.asPlayer());
		addPlayer(team2, Players.apps.asPlayer());
		addPlayer(team2, Players.snakes.asPlayer());
		addPlayer(team2, Players.mitchell.asPlayer());
		addPlayer(team2, Players.east.asPlayer());
		addPlayer(team2, Players.henso.asPlayer());
		addPlayer(team2, Players.oshea.asPlayer());
		addPlayer(team2, Players.gav.asPlayer());
		addPlayer(team2, Players.damo.asPlayer());

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.abbotsley.asVenue(), Utils.asDate("2007-09-16"), team1,
				team2);
		wc.setPuttOffWinner(Players.east.asPlayer());
		wc.setAlternativeWoodmanCupWinner(Players.denno.asPlayer());
		list.add(wc);
	}

}
