package org.waga.player;

import java.util.Date;

public class HandicapAdjustment {

	private static final int MAX_HANDICAP = 28;

	private Type type;
	private int value;
	private String message;
	private Date adjustmentDate;

	public enum Type {
		SET, INCREMENT, DECREMENT;
	}

	public HandicapAdjustment(Type type, int value, String message, Date adjustmentDate) {
		this.type = type;
		this.value = value;
		this.message = message;
		this.adjustmentDate = adjustmentDate;
	}

	public Date getAdjustmentDate() {
		return adjustmentDate;
	}

	public String getMessage() {
		return message;
	}

	public Type getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	public int adjust(int handicap) {
		if (type == Type.DECREMENT) {
			if (handicap - value < 0) {
				return 0;
			}
			return handicap - value;
		} else if (type == Type.INCREMENT) {
			if (handicap + value > MAX_HANDICAP) {
				return MAX_HANDICAP;
			}
			return handicap + value;
		}
		return value;
	}

}
