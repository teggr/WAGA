package org.waga;

import java.util.List;

import org.waga.player.Player;
import org.waga.venue.Venue;

public interface WagaData {
	
	List<Player> getPlayers();
	
	List<Venue> getVenues();

}
