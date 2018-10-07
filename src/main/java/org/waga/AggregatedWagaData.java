package org.waga;

import java.util.List;

import org.waga.player.Player;
import org.waga.venue.Venue;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.statistics.HallOfFameEntry;

public class AggregatedWagaData implements WagaData {

	private List<Player> players;
	private List<Venue> venues;
	private List<WoodmanCupEvent> woodmanCupEvents;
	private List<HallOfFameEntry> hallOfFame;

	public AggregatedWagaData(List<Player> players, List<Venue> venues,

			List<WoodmanCupEvent> woodmanCupEvents, List<HallOfFameEntry> hallOfFame) {
		this.players = players;
		this.venues = venues;
		this.woodmanCupEvents = woodmanCupEvents;
		this.hallOfFame = hallOfFame;
	}

	@Override
	public List<Player> getPlayers() {
		return players;
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
