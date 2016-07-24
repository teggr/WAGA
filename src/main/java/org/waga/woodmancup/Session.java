package org.waga.woodmancup;

import java.util.List;

public class Session {

	public static enum Type {
		FRIDAY, SATURDAY, SUNDAY;
	}

	public static enum Format {
		PAIRS, SINGLES;
	}
	
	private List<Match> matches;
	private Type type;
	private Format format;
	
	public Session(Type type, Format format) {
		this.type = type;
		this.format = format;
	}
	
	public Format getFormat() {
		return format;
	}
	
	public Type getType() {
		return type;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void addMatches(List<Match> matches) {
		matches.addAll(matches);
	}
}
