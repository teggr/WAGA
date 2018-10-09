package org.waga.woodmancup.statistics;

import org.waga.woodmancup.Session;
import org.waga.woodmancup.Session.Format;

public class SessionRecord implements Comparable<SessionRecord> {

	private int losses = 0;
	private int wins = 0;
	private final Session.Type type;

	public SessionRecord(Session.Type type) {
		super();
		this.type = type;
	}
	
	public Session.Type getType() {
		return type;
	}

	public void recordLoss() {
		losses++;
	}

	public int getLosses() {
		return losses;
	}

	public void recordWin() {
		wins++;
	}

	public int getWins() {
		return wins;
	}

	@Override
	public int compareTo(SessionRecord o) {
		return type.ordinal() - o.type.ordinal();
	}
	
}
