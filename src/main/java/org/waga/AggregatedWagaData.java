package org.waga;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.PlayerProfile;
import org.waga.player.Players;

public class AggregatedWagaData implements WagaData {
	@Override
	public List<PlayerProfile> getPlayerProfiles() {
		return Arrays.asList(Players.values()).stream().map(p -> p.getDetails()).collect(Collectors.toList());
	}
}
