package org.waga;

import java.util.List;

import org.waga.player.Player;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaStats;
import org.waga.venue.Venue;

public class AggregatedWagaData implements WagaData {

	private RaceToCiaoBellaStats currentRaceToCiaoBellaSeasonStats;
	private RaceToCiaoBella currentRaceToCiaBellaSeason;
	private List<Player> players;
	private List<Venue> venues;

	public AggregatedWagaData(List<Player> players, List<Venue> venues,
			RaceToCiaoBellaStats currentRaceToCiaoBellaSeasonStats, RaceToCiaoBella currentRaceToCiaBellaSeason) {
		this.players = players;
		this.venues = venues;
		this.currentRaceToCiaoBellaSeasonStats = currentRaceToCiaoBellaSeasonStats;
		this.currentRaceToCiaBellaSeason = currentRaceToCiaBellaSeason;
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

}
