package com.woodmancup.tournaments;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Repository;

import com.woodmancup.venues.VenueRepository;

@Repository
public class TournamentRepository implements InitializingBean {

	public enum TournamentSort implements Comparator<WoodmanCupEvent> {
		DATE_REVERSE;
		@Override
		public int compare(WoodmanCupEvent o1, WoodmanCupEvent o2) {
			long diff = o1.getDate().getTime() - o2.getDate().getTime();
			if (diff > 0) {
				return 1;
			} else if (diff < 0) {
				return -1;
			}
			return 0;
		}
	}

	private final List<WoodmanCupEvent> tournaments = new ArrayList<WoodmanCupEvent>();

	private final DateFormatter dateFormatter = new DateFormatter("dd/MM/yyyy");

	private VenueRepository venueRepository;

	private SessionRepository sessionRepository;

	@Autowired
	public void setVenueRepository(VenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	@Autowired
	public void setSessionRepository(SessionRepository resultRepository) {
		this.sessionRepository = resultRepository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		tournaments.add(create2005());
		tournaments.add(create2006());
		tournaments.add(create2007());
		tournaments.add(create2008());
		tournaments.add(create2009());
		tournaments.add(create2010());
		tournaments.add(create2011());
		tournaments.add(create2012());
	}

	private WoodmanCupEvent create2012() {
		return WoodmanCupEvent.newInstance("2012", venueRepository
				.findById("manorofgroves"), createDate("16/10/2012"), Team
				.newInstanceAsWinner("gunt", "GUNT", "Blue"), Team
				.newInstance("hensoes", "Bare naked henso's hensoes",
						"Yellow"), sessionRepository
				.findSessionsByTournamentId("2012"));
	}
	
	private WoodmanCupEvent create2011() {
		return WoodmanCupEvent.newInstance("2011", venueRepository
				.findById("staverton"), createDate("16/09/2011"), Team
				.newInstance("pink", "Pink Shirts And Cts", "Pink"), Team
				.newInstanceAsWinner("bear", "Gentle Ben Bear Society Cts",
						"Orange"), sessionRepository
				.findSessionsByTournamentId("2011"));
	}

	private WoodmanCupEvent create2010() {
		return WoodmanCupEvent.newInstance("2010",
				venueRepository.findById("oldthorns"),
				createDate("16/09/2010"),
				Team.newInstanceAsWinner("dog", "Da Dog Pound", "Pale Blue"),
				Team.newInstance("top", "The Top Guns", "Turquoise"),
				sessionRepository.findSessionsByTournamentId("2010"));
	}

	private WoodmanCupEvent create2009() {
		return WoodmanCupEvent.newInstance("2009", venueRepository
				.findById("donnington"), createDate("16/09/2009"), Team
				.newInstance("prince", "Prince Of Snakes", "Lime Green"), Team
				.newInstanceAsWinner("sinn", "Sinn Fein In The Membrane",
						"Lilac"), sessionRepository
				.findSessionsByTournamentId("2009"));
	}

	private WoodmanCupEvent create2008() {
		return WoodmanCupEvent.newInstance("2008", venueRepository
				.findById("hastings"), createDate("16/09/2008"), Team
				.newInstanceAsWinner("hoo", "The Hoo-Yahs", "Royal Blue"), Team
				.newInstance("mutiny", "Whoooooooaaah-(M)utiny on the Bounty",
						"Fire Engine Red"), sessionRepository
				.findSessionsByTournamentId("2008"));
	}

	private WoodmanCupEvent create2007() {
		return WoodmanCupEvent.newInstance("2007", venueRepository.findById("abbot"),
				createDate("16/09/2007"), Team.newInstanceAsWinner("neo",
						"The Neapolitans", "Chocolate Brown"), Team
						.newInstance("chalice", "Chalice Of Banter",
								"Burnt Orange"), sessionRepository
						.findSessionsByTournamentId("2007"));
	}

	private WoodmanCupEvent create2006() {
		return WoodmanCupEvent.newInstance("2006", venueRepository.findById("dorset"),
				createDate("16/09/2006"),
				Team.newInstance("scuzz", "Team Scuzz", "Yellow"),
				Team.newInstanceAsWinner("team2", "Team 2", "Beige"),
				sessionRepository.findSessionsByTournamentId("2006"));
	}

	private WoodmanCupEvent create2005() {
		return WoodmanCupEvent.newInstance("2005",
				venueRepository.findById("bidford"), createDate("16/09/2005"),
				Team.newInstanceAsWinner("gash", "The Gash", "Pink"),
				Team.newInstance("panthers", "The Sex Panthers", "Black"),
				sessionRepository.findSessionsByTournamentId("2005"));
	}

	public Date createDate(String dateString) {
		try {
			return dateFormatter.parse(dateString, Locale.getDefault());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<WoodmanCupEvent> findAll(TournamentSort sort) {
		List<WoodmanCupEvent> allTournaments = new ArrayList<WoodmanCupEvent>();
		allTournaments.addAll(tournaments);
		Collections.sort(allTournaments, sort);
		return allTournaments;
	}

	public WoodmanCupEvent findById(String id) {
		for (WoodmanCupEvent tournament : tournaments) {
			if (tournament.getId().equals(id)) {
				return tournament;
			}
		}
		return null;
	}

	public WoodmanCupEvent findByTeamId(String teamId) {
		for (WoodmanCupEvent tournament : tournaments) {
			if (tournament.hasTeam(teamId)) {
				return tournament;
			}
		}
		return null;
	}

}
