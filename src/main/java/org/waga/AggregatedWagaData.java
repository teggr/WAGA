package org.waga;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.venue.Venue;
import org.waga.venue.Venues;

public class AggregatedWagaData implements WagaData {

	@Override
	public List<Player> getPlayers() {
		return Arrays.asList(Players.values()).stream().map(p -> p.asPlayer()).collect(Collectors.toList());
	}

	@Override
	public List<Venue> getVenues() {
		return Arrays.asList(Venues.values()).stream().map(v -> v.asVenue()).collect(Collectors.toList());
	}

}
