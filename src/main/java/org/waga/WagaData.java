package org.waga;

import java.util.List;

import org.waga.player.Player;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaStats;
import org.waga.seedings.Seeding;
import org.waga.venue.Venue;

public interface WagaData {
	
	List<Player> getPlayers();
	
	List<Venue> getVenues();

	RaceToCiaoBella getCurrentRaceToCiaBellaSeason();

	RaceToCiaoBellaStats getCurrentRaceToCiaoBellaSeasonStats();
	
	List<Seeding> getSeedings();

}
