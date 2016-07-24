package com.woodmancup.tournaments;

import java.util.List;

import org.waga.player.Players;

import com.woodmancup.tournaments.Match.MatchBuilder;

public class WoodmanCupEventDataProvider {

	public static void addPlayer( Team t, Players p ) {
		t.addPlayer(p.asPlayer());
	}
	
	public static void addMatch( MatchBuilder b, List<Match> list ) {
		list.add(b.build());
	}
	
}
