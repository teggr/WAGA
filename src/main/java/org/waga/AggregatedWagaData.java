package org.waga;

import java.util.List;

import org.waga.open.OpenChallengeEvent;
import org.waga.player.Player;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaStats;
import org.waga.seedings.Seeding;
import org.waga.venue.Venue;
import org.waga.woodmancup.WoodmanCupEvent;

public class AggregatedWagaData implements WagaData {

	private RaceToCiaoBellaStats currentRaceToCiaoBellaSeasonStats;
	private RaceToCiaoBella currentRaceToCiaBellaSeason;
	private List<Player> players;
	private List<Venue> venues;
	private List<Seeding> seedings;
	private List<OpenChallengeEvent> openEvents;
	private List<WoodmanCupEvent> woodmanCupEvents;

	public AggregatedWagaData(List<Player> players, List<Venue> venues,
			RaceToCiaoBellaStats currentRaceToCiaoBellaSeasonStats, RaceToCiaoBella currentRaceToCiaBellaSeason,
			List<Seeding> seedings, List<OpenChallengeEvent> openEvents, List<WoodmanCupEvent> woodmanCupEvents) {
		this.players = players;
		this.venues = venues;
		this.currentRaceToCiaoBellaSeasonStats = currentRaceToCiaoBellaSeasonStats;
		this.currentRaceToCiaBellaSeason = currentRaceToCiaBellaSeason;
		this.seedings = seedings;
		this.openEvents = openEvents;
		this.woodmanCupEvents = woodmanCupEvents;
	}

	@Override
	public RaceToCiaoBellaStats getCurrentRaceToCiaoBellaSeasonStats() {
		return currentRaceToCiaoBellaSeasonStats;
	}

	@Override
	public RaceToCiaoBella getCurrentRaceToCiaBellaSeason() {
		return currentRaceToCiaBellaSeason;
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
	public List<Seeding> getSeedings() {
		return seedings;
	}
	
	@Override
	public List<OpenChallengeEvent> getOpenChallengeEvents() {
		return openEvents;
	}
	
	@Override
	public List<WoodmanCupEvent> getWoodmanCupEvents() {
		return woodmanCupEvents;
	}

}
