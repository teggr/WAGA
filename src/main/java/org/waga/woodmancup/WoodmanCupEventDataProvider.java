package org.waga.woodmancup;

import java.util.List;

import org.waga.player.Players;
import org.waga.woodmancup.Match.MatchBuilder;

public abstract class WoodmanCupEventDataProvider {

	protected void addPlayer(Team t, Players p) {
		t.addPlayer(p.asPlayer());
	}

	protected void addMatch(MatchBuilder b, List<Match> list) {
		list.add(b.build());
	}

	public abstract void registerEvent(List<WoodmanCupEvent> list);

}
