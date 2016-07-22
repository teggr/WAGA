package org.waga;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.waga.player.Player;

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

	public List<Player> byListAppearanceDate(List<Player> profiles) {
		return profiles.stream().sorted((p1, p2) -> p1.getLastAppearance().compareTo(p2.getLastAppearance()))
				.collect(Collectors.toList());
	}

	public String getProfileId(Player profile) {
		return profile.getFullName().toLowerCase().replaceAll(" ", "-").replaceAll("'", "");
	}

}
