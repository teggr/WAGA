package org.waga.woodmancup.statistics;

import java.util.ArrayList;
import java.util.List;

import org.waga.woodmancup.Match.Result;

public class WoodmanCupRecord {

	private boolean puttOffWin = false;
	private boolean alternativeWoodmanCupWin = false;
	private List<Result> results = new ArrayList<>();
	private boolean woodmanCupWin = false;

	public void addPuttOffWin() {
		puttOffWin = true;
	}

	public void addAlternativeWoodmanCupWin() {
		alternativeWoodmanCupWin = true;
	}

	public void addResult(Result result) {
		results.add(result);
	}

	public void addWoodmanCupWin() {
		woodmanCupWin = true;
	}

	public boolean isPuttOffWin() {
		return puttOffWin;
	}

	public boolean isAlternativeWoodmanCupWin() {
		return alternativeWoodmanCupWin;
	}

	public boolean isWoodmanCupWin() {
		return woodmanCupWin;
	}

	public List<Result> getResults() {
		return results;
	}

	public int getWins() {
		return (int) results.stream().filter(r -> r == Result.BEAT).count();
	}

	public int getDraws() {
		return (int) results.stream().filter(r -> r == Result.DREW_WITH).count();
	}

	public int getLosses() {
		return (int) results.stream().filter(r -> r == Result.LOST_TO).count();
	}

}
