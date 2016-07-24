package org.waga.woodmancup.statistics;

import org.waga.woodmancup.WoodmanCupEvent;

public interface WoodmanCupEventStatsAggregator {

	void aggregate(WoodmanCupEvent event);

}
