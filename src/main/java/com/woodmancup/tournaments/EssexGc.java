package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class EssexGc extends WoodmanCupEventDataProvider {

	static void essecgc(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("Head Up The Snakes", "Blue", Players.snakes.asPlayer());
		addPlayer(team1, Players.teggy.asPlayer());
		addPlayer(team1, Players.dan.asPlayer());
		addPlayer(team1, Players.foist.asPlayer());
		addPlayer(team1, Players.maddog.asPlayer());
		addPlayer(team1, Players.snakes.asPlayer());
		addPlayer(team1, Players.apps.asPlayer());

		Team team2 = Team.newInstance("Y+M=19", "Yellow", Players.brad.asPlayer());
		addPlayer(team2, Players.brad.asPlayer());
		addPlayer(team2, Players.sturdy.asPlayer());
		addPlayer(team2, Players.steve.asPlayer());
		addPlayer(team2, Players.east.asPlayer());
		addPlayer(team2, Players.neil.asPlayer());
		addPlayer(team2, Players.sean.asPlayer());

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.essexgc.asVenue(), Utils.asDate("2013-09-16"), team1,
				team2);
		list.add(wc);
	}

}
