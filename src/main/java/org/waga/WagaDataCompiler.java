package org.waga;

import java.util.List;

import org.waga.player.Players;
import org.waga.venue.Venues;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.WoodmanCupEvents;
import org.waga.woodmancup.statistics.Aggy;
import org.waga.woodmancup.statistics.HallOfFameEntry;
import org.waga.woodmancup.statistics.PlayerStats;

public class WagaDataCompiler {

	public static WagaData compile() {

		List<WoodmanCupEvent> woodmanCupEvents = WoodmanCupEvents.getEvents();

		Aggy aggy = new Aggy(Players.asPlayers());
		for (WoodmanCupEvent woodmanCupEvent : woodmanCupEvents) {
			aggy.aggregate(woodmanCupEvent);
		}
		List<HallOfFameEntry> hallOfFame = aggy.getEntries();
		List<PlayerStats> playerStats = aggy.getPlayerStats();

		return new AggregatedWagaData(playerStats, Venues.asVenues(), woodmanCupEvents, hallOfFame);

	}

}
