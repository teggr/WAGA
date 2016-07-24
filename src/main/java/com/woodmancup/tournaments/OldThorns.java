package com.woodmancup.tournaments;

import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class OldThorns  extends WoodmanCupEventDataProvider{

	static void oldthorns(List<WoodmanCupEvent> list) {
		Team team1 = Team.newInstanceAsWinner("Da Dog Pound", "Pale Blue", Players.maddog.asPlayer());
		addPlayer(team1, Players.snakes.asPlayer());
		addPlayer(team1, Players.brad.asPlayer());
		addPlayer(team1, Players.teggy.asPlayer());
		addPlayer(team1, Players.henso.asPlayer());
		addPlayer(team1, Players.maddog.asPlayer());
		addPlayer(team1, Players.putts.asPlayer());
		addPlayer(team1, Players.coco.asPlayer());
		addPlayer(team1, Players.foist.asPlayer());
		
		Team team2 = Team.newInstance("The Top Guns", "Turquoise", Players.gav.asPlayer());
		addPlayer(team2, Players.apps.asPlayer());
		addPlayer(team2, Players.sturdy.asPlayer());
		addPlayer(team2, Players.mitchell.asPlayer());
		addPlayer(team2, Players.east.asPlayer());
		addPlayer(team2, Players.greg.asPlayer());
		addPlayer(team2, Players.richg.asPlayer());
		addPlayer(team2, Players.gav.asPlayer());
		addPlayer(team2, Players.denno.asPlayer());
		
		WoodmanCupEvent wc = WoodmanCupEvent.newInstance(Venues.oldthorns.asVenue(), Utils.asDate("2010-09-16"), team1, team2);
		wc.setPuttOffWinner(Players.putts.asPlayer());
		list.add(wc);
	}

}
