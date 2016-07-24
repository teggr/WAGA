package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class Bidford extends WoodmanCupEventDataProvider {

	static void bidford(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("The Gash", "Pink", Players.sturdy.asPlayer());
		addPlayer(team1,Players.apps.asPlayer());
		addPlayer(team1,Players.sturdy.asPlayer());
		addPlayer(team1,Players.shifty.asPlayer());
		addPlayer(team1,Players.kempo.asPlayer());
		addPlayer(team1,Players.snakes.asPlayer());
		addPlayer(team1,Players.brad.asPlayer());
		
		Team team2 = Team.newInstance("The Sex Panthers", "Black", Players.east.asPlayer());
		addPlayer(team2,Players.teggy.asPlayer());
		addPlayer(team2,Players.mitchell.asPlayer());
		addPlayer(team2,Players.mac.asPlayer());
		addPlayer(team2,Players.east.asPlayer());
		addPlayer(team2,Players.henso.asPlayer());
		addPlayer(team2,Players.greg.asPlayer());
		
		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.bidford.asVenue(), Utils.asDate("2005-09-16"), team1, team2);
		list.add(wc);
	}

}
