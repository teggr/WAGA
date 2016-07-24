package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Dorset extends WoodmanCupEventDataProvider {

	static void dorset(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstance("Team Scuzz", "Yellow", Players.apps.asPlayer());
		addPlayer(team1,Players.apps.asPlayer());
		addPlayer(team1,Players.snakes.asPlayer());
		addPlayer(team1,Players.east.asPlayer());
		addPlayer(team1,Players.henso.asPlayer());
		addPlayer(team1,Players.greg.asPlayer());
		addPlayer(team1,Players.flaps.asPlayer());
		
		Team team2 = Team.newInstanceAsWinner("Team 2", "Beige", Players.sturdy.asPlayer());
		addPlayer(team2,Players.sturdy.asPlayer());
		addPlayer(team2,Players.brad.asPlayer());
		addPlayer(team2,Players.teggy.asPlayer());
		addPlayer(team2,Players.mitchell.asPlayer());
		addPlayer(team2,Players.mac.asPlayer());
		addPlayer(team2,Players.maddog.asPlayer());
		
		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.dorset.asVenue(), Utils.asDate("2006-09-16"), team1, team2);
		list.add(wc);
	}

}
