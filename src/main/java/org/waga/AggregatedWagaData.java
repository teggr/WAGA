package org.waga;

import java.util.List;

import org.waga.venue.Venue;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.statistics.HallOfFameEntry;
import org.waga.woodmancup.statistics.PlayerStats;

public class AggregatedWagaData implements WagaData {

	private List<PlayerStats> playerStats;
	private List<Venue> venues;
	private List<WoodmanCupEvent> woodmanCupEvents;
	private List<HallOfFameEntry> hallOfFame;

	public AggregatedWagaData(List<PlayerStats> playerStats, List<Venue> venues, List<WoodmanCupEvent> woodmanCupEvents,
			List<HallOfFameEntry> hallOfFame) {
		this.playerStats = playerStats;
		this.venues = venues;
		this.woodmanCupEvents = woodmanCupEvents;
		this.hallOfFame = hallOfFame;
	}

	@Override
	public List<PlayerStats> getPlayerStats() {
		return playerStats;
	}

	@Override
	public List<Venue> getVenues() {
		return venues;
	}

	@Override
	public List<WoodmanCupEvent> getWoodmanCupEvents() {
		return woodmanCupEvents;
	}

	@Override
	public WoodmanCupEvent getWoodmanCupEvent(String year) {
		for (WoodmanCupEvent event : woodmanCupEvents) {
			if (event.isYear(year)) {
				return event;
			}
		}
		return null;
	}

	@Override
	public List<HallOfFameEntry> getHallOfFame() {
		return hallOfFame;
	}

}
