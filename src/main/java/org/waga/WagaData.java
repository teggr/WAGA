package org.waga;

import java.util.List;

import org.waga.player.Player;
import org.waga.venue.Venue;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.statistics.HallOfFameEntry;

public interface WagaData {
	
	List<Player> getPlayers();
	
	List<Venue> getVenues();
	
	List<WoodmanCupEvent> getWoodmanCupEvents();
	
	WoodmanCupEvent getWoodmanCupEvent(String event);

	List<HallOfFameEntry> getHallOfFame();

}
