package org.waga;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.util.DateUtils;
import org.waga.core.Player;
import org.waga.core.PlayerRepository;
import org.waga.core.Venue;
import org.waga.core.VenueRepository;
import org.waga.news.NewsItem;
import org.waga.news.NewsItemRepository;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaRepository;
import org.waga.rtcb.Result;
import org.waga.rtcb.Tournament;

@SpringBootApplication
public class WagaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WagaApplication.class, args);
	}

	@Autowired
	private VenueRepository venueRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private NewsItemRepository newsItemRepository;

	@Autowired
	private RaceToCiaoBellaRepository raceToCiaoBellaRepository;

	@PostConstruct
	public void initialise() {

		Venue venue = new Venue();
		venue.setName("Shirley Park GC");
		venueRepository.save(venue);

		Player player = new Player();
		player.setFirstName("Thomas");
		player.setSurname("Apperley");
		player.setCurrentHandicap(12);
		playerRepository.save(player);

		RaceToCiaoBella raceToCiaoBella = new RaceToCiaoBella();
		raceToCiaoBella.setSeason(2016);
		Set<Tournament> rounds = new HashSet<>();
		Tournament round = new Tournament();
		round.setDate(DateUtils.create(2015, 12, 29).getTime());
		round.setVenue(venue);
		Set<Result> results = new HashSet<>();
		Result result = new Result();
		result.setPlayer(player);
		result.setHandicap(player.getCurrentHandicap());
		result.setScore(36);
		results.add(result);
		round.setResults(results);
		rounds.add(round);
		raceToCiaoBella.setTournaments(rounds);
		raceToCiaoBellaRepository.save(raceToCiaoBella);

		NewsItem item1 = new NewsItem();
		item1.setTitle("Apperley storms to top of leaderboard");
		item1.setSummary(
				"Thomas Apperley shows strong will power to take the lead as David Tryhorn slumps to fourth place");
		item1.setImageUrl("http://www.munosconggolf.com/wp-content/uploads/2011/07/golf-swing-tips.jpg");
		item1.setLink("http://localhost:8080/racetociaobella/rounds/2");
		Date createdTime = new Date();
		item1.setCreatedTime(createdTime);
		item1.setTag("Race to Ciao Bella");
		newsItemRepository.save(item1);

	}
}
