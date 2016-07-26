package org.waga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.core.Utils;
import org.waga.open.OpenChallengeEvent;
import org.waga.open.OpenChallengeEvents;
import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaEvents;
import org.waga.rtcb.RaceToCiaoBellaScoreHandicapAdjuster;
import org.waga.rtcb.RaceToCiaoBellaStats;
import org.waga.rtcb.RaceToCiaoBellaWinningHandicapAdjuster;
import org.waga.seedings.Seeding;
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
						if (p1.isCurrent() && p2.isCurrent()) {
							return 0;
						}
						if (p1.isCurrent()) {
							return -1;
						}
						return +1;
					}
				}).collect(Collectors.toList());

		List<Seeding> seedings = Arrays.asList(Players.values()).stream().map(p -> p.asPlayer())
				.filter(p -> p.isCurrent()).sorted((p1, p2) -> p1.getCurrentHandicap() - p2.getCurrentHandicap())
				.map(p -> new Seeding(p)).collect(Collectors.toList());

		List<Venue> venues = Arrays.asList(Venues.values()).stream().map(v -> v.asVenue()).collect(Collectors.toList());

		List<RaceToCiaoBella> seasons = RaceToCiaoBellaEvents.getEvents();
		RaceToCiaoBella currentSeason = seasons.get(seasons.size() - 1);
		RaceToCiaoBellaStats currentSeasonStats = new RaceToCiaoBellaStats(currentSeason);

		// adjust handicaps
		RaceToCiaoBellaScoreHandicapAdjuster scoreAdjuster = new RaceToCiaoBellaScoreHandicapAdjuster();
		scoreAdjuster.apply(currentSeason);

		RaceToCiaoBellaWinningHandicapAdjuster winningScoreAdjuster = new RaceToCiaoBellaWinningHandicapAdjuster(
				Utils.asDate("2016-04-21"));
		winningScoreAdjuster.apply(currentSeason);

		List<OpenChallengeEvent> openEvents = OpenChallengeEvents.getEvents();

		List<WoodmanCupEvent> woodmanCupEvents = WoodmanCupEvents.getEvents();
		
		Aggy aggy = new Aggy(players);
		for (WoodmanCupEvent woodmanCupEvent : woodmanCupEvents) {
			aggy.aggregate( woodmanCupEvent );			
		}
		List<HallOfFameEntry> hallOfFame = aggy.getEntries();
		
		return new AggregatedWagaData(players, venues, currentSeasonStats, currentSeason, seedings, openEvents, woodmanCupEvents, hallOfFame );

	}

}
