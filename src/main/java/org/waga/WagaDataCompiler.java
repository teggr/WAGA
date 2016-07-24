package org.waga;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaEvents;
import org.waga.rtcb.RaceToCiaoBellaStats;
import org.waga.venue.Venue;
import org.waga.venue.Venues;

public class WagaDataCompiler {

	public static WagaData compile() {

		List<Player> players = Arrays.asList(Players.values()).stream().map(p -> p.asPlayer())
				.collect(Collectors.toList());

		List<Venue> venues = Arrays.asList(Venues.values()).stream().map(v -> v.asVenue()).collect(Collectors.toList());

		List<RaceToCiaoBella> seasons = RaceToCiaoBellaEvents.getEvents();
		RaceToCiaoBella currentSeason = seasons.get(seasons.size() - 1);
		RaceToCiaoBellaStats currentSeasonStats = new RaceToCiaoBellaStats(currentSeason);

		return new AggregatedWagaData(players, venues, currentSeasonStats, currentSeason);

	}

}
