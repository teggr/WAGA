package org.waga.core;

import java.util.List;

public class Ranking {

	public static void rank(List<? extends Rankable> rankables) {

		int currentPosition = 0;
		int nextPosition = 1;
		int lastScore = -1;

		for (Rankable toRank : rankables) {
			int score = toRank.getRankableValue();
			if (score != lastScore) {
				currentPosition = nextPosition;
			}
			toRank.setRanking(currentPosition);
			lastScore = score;
			nextPosition++;
		}

	}

}
