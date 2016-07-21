package org.waga.web;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ViewHelper {

	public String elapsedTime(Date createdDate) {

		LocalDate localDate = createdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		LocalDate now = LocalDate.now();

		Period period = Period.between(localDate, now);

		if (period.getYears() > 0) {
			return period.getYears() + "y";
		}
		if (period.getMonths() > 0) {
			return period.getMonths() + "m";
		}
		return period.getDays() + "d";
	}

}
