package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Staverton extends WoodmanCupEventDataProvider {

	static void staverton(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstance("Pink Shirts And Cts", "Pink", Players.foist.asPlayer());
		addPlayer(team1, Players.apps.asPlayer());
		addPlayer(team1, Players.snakes.asPlayer());
		addPlayer(team1, Players.greg.asPlayer());
		addPlayer(team1, Players.putts.asPlayer());
		addPlayer(team1, Players.gav.asPlayer());
		addPlayer(team1, Players.foist.asPlayer());
		
		Team team2 = Team.newInstanceAsWinner("Gentle Ben Bear Society Cts", "Orange", Players.brad.asPlayer());
		addPlayer(team2, Players.sturdy.asPlayer());
		addPlayer(team2, Players.brad.asPlayer());
		addPlayer(team2, Players.teggy.asPlayer());
		addPlayer(team2, Players.east.asPlayer());
		addPlayer(team2, Players.henso.asPlayer());
		addPlayer(team2, Players.maddog.asPlayer());
		
		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.staverton.asVenue(), Utils.asDate("2011-09-16"), team1, team2);
		wc.setPuttOffWinner(Players.maddog.asPlayer());
		list.add(wc);
	}

}
