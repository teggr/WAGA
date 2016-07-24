package org.waga.woodmancup.statistics;

import java.util.ArrayList;
import java.util.List;

import org.waga.woodmancup.Session;
import org.waga.woodmancup.WoodmanCupEvent;

public class HallOfFamesStatsAggregator implements WoodmanCupEventStatsAggregator {

	private List<HallOfFameEntry> hallOfFameList = new ArrayList<>();

	@Override
	public void aggregate(WoodmanCupEvent event) {
		
		// run through all the session, assigning points for wins and draws
		// run through other putt off woodman,
		// from who won, assign those to the entrues
		
		List<Session> sessions = event.getSessions();

	}

	public List<HallOfFameEntry> getEntries() {
		return hallOfFameList;
	}

}
