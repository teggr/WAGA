package org.waga.woodmancup.statistics;

import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;
import org.waga.woodmancup.WoodmanCupEvent;

public class Aggy implements WoodmanCupEventStatsAggregator {

	private List<PlayerDataCollector> collectors;

	public Aggy(List<Player> players) {
		collectors = players.stream().map(p -> new PlayerDataCollector(p)).collect(Collectors.toList());
	}

	@Override
	public void aggregate(WoodmanCupEvent event) {
		for (PlayerDataCollector collector : collectors) {
			collector.aggregate(event);
		}
	}

	public List<HallOfFameEntry> getEntries() {
		return collectors.stream().map(c -> c.toHallOfFameEntry()).sorted((h1, h2) -> h2.getPoints() - h1.getPoints())
				.collect(Collectors.toList());
	}

}
