package org.waga.web;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ViewHelper {

	public String elapsedTime(Date createdTime) {

		Period period = Period.between(createdTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				LocalDate.now());
		
		
		return period.getDays() + "d";

	}

}
