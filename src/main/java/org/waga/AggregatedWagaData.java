package org.waga;

import java.util.List;

import org.waga.player.Player;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaStats;
import org.waga.venue.Venue;

public class AggregatedWagaData implements WagaData {

	private RaceToCiaoBellaStats currentRaceToCiaoBellaSeasonStats;
	private List<RaceToCiaoBella> raceToCiaBellaSeasons;
	private List<Player> players;
	private List<Venue> venues;

	public AggregatedWagaData(List<Player> players, List<Venue> venues,
			RaceToCiaoBellaStats currentRaceToCiaoBellaSeasonStats, List<RaceToCiaoBella> raceToCiaBellaSeasons) {
		this.players = players;
		this.venues = venues;
		this.currentRaceToCiaoBellaSeasonStats = currentRaceToCiaoBellaSeasonStats;
		this.raceToCiaBellaSeasons = raceToCiaBellaSeasons;
	}

	@Override
	public RaceToCiaoBellaStats getCurrentRaceToCiaoBellaSeasonStats() {
		return currentRaceToCiaoBellaSeasonStats;
	}

	@Override
	public List<RaceToCiaoBella> getRaceToCiaBellaSeasons() {
		return raceToCiaBellaSeasons;
	}

	@Override
	public List<Player> getPlayers() {
		return players ;
	}

	@Override
	public List<Venue> getVenues() {
		return venues;
	}

}
