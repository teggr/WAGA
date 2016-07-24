package org.waga.woodmancup;

import java.util.ArrayList;
import java.util.List;

public class Session {

	public static enum Type {
		FRIDAY, SATURDAY, SUNDAY;
	}

	public static enum Format {
		PAIRS, SINGLES;
	}
	
	private List<Match> matches = new ArrayList<>();
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
		this.matches.addAll(matches);
	}

	public double getTeam1Points() {
		double total = 0;
		for (Match match : matches) {
			total = total + match.getTeamAPoints();
		}
		return total;
	}

	public double getTeam2Points() {
		double total = 0;
		for (Match match : matches) {
			total = total + match.getTeamBPoints();
		}
		return total;
	}
}
