package org.waga.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Player {

	private static final Comparator<HandicapAdjustment> ORDER_BY_DATE_OLDEST_FIRST = new Comparator<HandicapAdjustment>() {
		@Override
		public int compare(HandicapAdjustment o1, HandicapAdjustment o2) {
			return o1.getAdjustmentDate().compareTo(o2.getAdjustmentDate());
		}
	};

	private static final Comparator<HandicapAdjustment> REVERSE_ORDER_BY_DATE_NEWEST_FIRST = new Comparator<HandicapAdjustment>() {
		@Override
		public int compare(HandicapAdjustment o1, HandicapAdjustment o2) {
			return o2.getAdjustmentDate().compareTo(o1.getAdjustmentDate());
		}
	};

	public static Player with(String firstName, String surname, int joiningHandicap, String imageUrl, Date joinDate) {
		Player player = new Player();
		player.joinDate = joinDate;
		player.firstName = firstName;
		player.surname = surname;
		player.imageUrl = imageUrl;
		player.setHandicap(joiningHandicap, "Joining handicap", joinDate);
		return player;
	}

	private Date joinDate;
	private String firstName;
	private String surname;
	private String imageUrl;
	private Date lastAppearance = new java.util.Date(0);
	private boolean current;

	private List<HandicapAdjustment> handicapAdjustments = new ArrayList<>();

	private Player() {
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public Player setCurrent() {
		current = true;
		return this;
	}

	public void recordAppearance(Date appearanceDate) {
		this.lastAppearance = appearanceDate;
	}

	public Date getLastAppearance() {
		return lastAppearance;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public int getCurrentHandicap() {
		int handicap = 0;
		for (HandicapAdjustment adjustment : handicapAdjustments) {
			handicap = adjustment.adjust(handicap);
		}
		return handicap;
	}

	public List<HandicapAdjustment> getHandicapAdjustments() {
		return handicapAdjustments;
	}

	public List<String> getHandicapAdjustmentDetails() {
		ArrayList<String> sortedList = new ArrayList<>();
		
		int handicap = 0;
		for (HandicapAdjustment adjustment : handicapAdjustments) {
			handicap = adjustment.adjust(handicap);
			sortedList.add( handicap + " : " + adjustment.getMessage() );
		}
		Collections.reverse(sortedList);
		return sortedList;
	}

	public List<String> getHandicapAdjustmentDates() {
		List<String> dates = new ArrayList<>();
		for (HandicapAdjustment adjustment : handicapAdjustments) {
			dates.add(org.waga.core.Utils.dateToString(adjustment.getAdjustmentDate()));
		}
		return dates;
	}

	public List<Number> getHandicapAdjustmentsTimeline() {
		List<Number> timeline = new ArrayList<>();
		int handicap = 0;
		for (HandicapAdjustment adjustment : handicapAdjustments) {
			handicap = adjustment.adjust(handicap);
			timeline.add(handicap);
		}
		return timeline;
	}

	public String getFullName() {
		return firstName + " " + surname;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setHandicap(int handicap, String message, Date date) {
		handicapAdjustments.add(new HandicapAdjustment(HandicapAdjustment.Type.SET, handicap, message, date));
		handicapAdjustments.sort(ORDER_BY_DATE_OLDEST_FIRST);
	}

	public void incrementHandicap(int increment, String message, Date date) {
		handicapAdjustments.add(new HandicapAdjustment(HandicapAdjustment.Type.INCREMENT, increment, message, date));
		handicapAdjustments.sort(ORDER_BY_DATE_OLDEST_FIRST);
	}

	public void decrementHandicap(int decrement, String message, Date date) {
		handicapAdjustments.add(new HandicapAdjustment(HandicapAdjustment.Type.DECREMENT, decrement, message, date));
		handicapAdjustments.sort(ORDER_BY_DATE_OLDEST_FIRST);
	}

}
