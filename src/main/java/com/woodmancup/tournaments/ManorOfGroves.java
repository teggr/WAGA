package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class ManorOfGroves extends WoodmanCupEventDataProvider {

	static void manorofgroves(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("GUNT", "Blue", Players.greg.asPlayer());
		addPlayer(team1, Players.apps.asPlayer());
		addPlayer(team1, Players.snakes.asPlayer());
		addPlayer(team1, Players.east.asPlayer());
		addPlayer(team1, Players.greg.asPlayer());
		addPlayer(team1, Players.maddog.asPlayer());
		addPlayer(team1, Players.mannix.asPlayer());

		Team team2 = Team.newInstance("Bare naked henso's hensoes", "Yellow", Players.henso.asPlayer());
		addPlayer(team2, Players.sturdy.asPlayer());
		addPlayer(team2, Players.brad.asPlayer());
		addPlayer(team2, Players.teggy.asPlayer());
		addPlayer(team2, Players.henso.asPlayer());
		addPlayer(team2, Players.coco.asPlayer());
		addPlayer(team2, Players.foist.asPlayer());

		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.manorofgroves.asVenue(), Utils.asDate("2012-10-16"),
				team1, team2);
		wc.setPuttOffWinner(Players.mannix.asPlayer());
		list.add(wc);
	}

}
