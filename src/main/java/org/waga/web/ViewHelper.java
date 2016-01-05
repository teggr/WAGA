package org.waga.web;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ViewHelper {

	private String viewName;

	public ViewHelper(String viewName) {
		this.viewName = viewName;
	}

	public String elapsedTime(Date createdDate) {
		Period period = Period.between(createdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				LocalDate.now());
		return period.getDays() + "d";
	}

	public boolean isActive(String viewName) {
		return viewName.equalsIgnoreCase(this.viewName);
	}

}
