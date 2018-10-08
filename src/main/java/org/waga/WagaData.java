package org.waga;

import java.util.List;

import org.waga.venue.Venue;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.statistics.HallOfFameEntry;
import org.waga.woodmancup.statistics.PlayerStats;

public interface WagaData {
	
	List<PlayerStats> getPlayerStats();
	
	List<Venue> getVenues();
	
	List<WoodmanCupEvent> getWoodmanCupEvents();
	
	WoodmanCupEvent getWoodmanCupEvent(String event);

	List<HallOfFameEntry> getHallOfFame();

}
