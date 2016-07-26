package org.waga.woodmancup.statistics;

import org.waga.player.Player;

public class RecordEntry {
	private Player member;
	private int value;

	public RecordEntry(Player member, int value) {
		super();
		this.member = member;
		this.value = value;
	}

	public Player getMember() {
		return member;
	}

	public int getValue() {
		return value;
	}
}
