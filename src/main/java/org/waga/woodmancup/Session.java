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

	public int getResult(String teamId, String memberId) {
		for (Match match : matches) {
			if (match.containsMember(memberId)) {
				if (match.getWinningTeamId().equals(teamId)) {
					return 1;
				} else if (match.getWinningTeamId().equals(Match.DRAW)) {
					return 0;
				}
			}
		}
		return -1;
	}

	public double getTeamPoints(String teamId) {
		double points = 0.0;
		for (Match match : matches) {
			if (match.getWinningTeamId().equals(teamId)) {
				points = points + 1.0;
			} else if (match.getWinningTeamId().equals(Match.DRAW)) {
				points = points + 0.5;
			}
		}
		return points;
	}

	public void addMatches(List<Match> matches) {
		matches.addAll(matches);
	}
}
