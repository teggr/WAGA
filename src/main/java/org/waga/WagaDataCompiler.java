package org.waga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.venue.Venue;
import org.waga.venue.Venues;
import org.waga.woodmancup.WoodmanCupEvent;
import org.waga.woodmancup.WoodmanCupEvents;
import org.waga.woodmancup.statistics.Aggy;
import org.waga.woodmancup.statistics.HallOfFameEntry;

public class WagaDataCompiler {

	public static WagaData compile() {

		List<Player> players = Arrays.asList(Players.values()).stream().map(p -> p.asPlayer())
				.sorted(new Comparator<Player>() {
					@Override
					public int compare(Player p1, Player p2) {
//						if (p1.isCurrent() && p2.isCurrent()) {
//							return 0;
//						}
//						if (p1.isCurrent()) {
//							return -1;
//						}
						return +1;
					}
				}).collect(Collectors.toList());

		List<Venue> venues = Arrays.asList(Venues.values()).stream().map(v -> v.asVenue()).collect(Collectors.toList());

		List<WoodmanCupEvent> woodmanCupEvents = WoodmanCupEvents.getEvents();

		Aggy aggy = new Aggy(players);
		for (WoodmanCupEvent woodmanCupEvent : woodmanCupEvents) {
			aggy.aggregate(woodmanCupEvent);
		}
		List<HallOfFameEntry> hallOfFame = aggy.getEntries();

		return new AggregatedWagaData(players, venues, woodmanCupEvents, hallOfFame);

	}

}
