package org.waga.player;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.format.datetime.DateFormatter;

public class HistoricHandicaps {

	private List<HistoricHandicap> historic;

	public HistoricHandicaps(List<HistoricHandicap> historic) {
		this.historic = historic;
	}

	public List<String> keys() {
		return historic.stream().map(h -> new DateFormatter("dd/MMM/yy").print(h.getExpiredDate(), Locale.getDefault()))
				.collect(Collectors.toList());
	}

	public List<Number> values() {
		return historic.stream().map(h -> h.getHandicap()).collect(Collectors.toList());
	}

}
