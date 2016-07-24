package org.waga.open;

import java.util.ArrayList;
import java.util.List;

import org.waga.core.Utils;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class OpenChallengeEvents {

	public static List<OpenChallengeEvent> getEvents() {
		List<OpenChallengeEvent> list = new ArrayList<OpenChallengeEvent>();
		cinquePorts(list);
		standrews(list);
		return list;
	}

	private static void cinquePorts(List<OpenChallengeEvent> list) {
		OpenChallengeEvent event = new OpenChallengeEvent(Venues.cinqueports.asVenue(), Utils.asDate("2016-06-24"));
		event.addResult(Players.apps.asPlayer(), 36);
		event.addResult(Players.teggy.asPlayer(), 32);
		list.add(event);
	}

	private static void standrews(List<OpenChallengeEvent> list) {
		OpenChallengeEvent event = new OpenChallengeEvent(Venues.standrews.asVenue(), Utils.asDate("2010-10-26"));
		event.addResult(Players.apps.asPlayer(), 33);
		event.addResult(Players.teggy.asPlayer(), 32);
		list.add(event);

	}

}
