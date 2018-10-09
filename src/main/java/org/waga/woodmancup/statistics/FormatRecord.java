package org.waga.woodmancup.statistics;

import org.waga.woodmancup.Session.Format;

public class FormatRecord {

	private int losses = 0;
	private int wins = 0;
	private final Format format;

	public FormatRecord(Format format) {
		super();
		this.format = format;
	}
	
	public Format getFormat() {
		return format;
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

}
