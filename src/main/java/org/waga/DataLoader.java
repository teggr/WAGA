package org.waga;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.DateUtils;
import org.waga.core.Player;
import org.waga.core.PlayerRepository;
import org.waga.core.Venue;
import org.waga.core.VenueRepository;
import org.waga.news.NewsItem;
import org.waga.news.NewsItemRepository;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaConstants;
import org.waga.rtcb.RaceToCiaoBellaRepository;
import org.waga.rtcb.Result;
import org.waga.rtcb.Tournament;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private VenueRepository venueRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private NewsItemRepository newsItemRepository;

	@Autowired
	private RaceToCiaoBellaRepository raceToCiaoBellaRepository;
	
	@Override
	public void run(String... arg0) throws Exception {

		Venue shirleyPark = new Venue();
		shirleyPark.setName("Shirley Park GC");
		shirleyPark.setImageUrl("http://www.shirleyparkgolfclub.co.uk/assets/img/course_shots/golf_hole1_tee.jpg");
		shirleyPark.setLink("http://www.shirleyparkgolfclub.co.uk/");
		venueRepository.save(shirleyPark);

		Venue theAddington = new Venue();
		theAddington.setName("The Addington");
		theAddington.setImageUrl("http://www.nationalclubgolfer.com/articles/article/addington-12th%7Cc%3A520x330.jpg");
		theAddington.setLink("http://www.addingtongolf.com/");
		venueRepository.save(theAddington);

		Player tom = new Player();
		tom.setFirstName("Thomas");
		tom.setSurname("Apperley");
		tom.setCurrentHandicap(12);
		playerRepository.save(tom);

		Player dave = new Player();
		dave.setFirstName("David");
		dave.setSurname("Tryhorn");
		dave.setCurrentHandicap(23);
		playerRepository.save(dave);

		Player brad = new Player();
		brad.setFirstName("Brad");
		brad.setSurname("Le Riche");
		brad.setCurrentHandicap(28);
		playerRepository.save(brad);

		Player robin = new Player();
		robin.setFirstName("Robin");
		robin.setSurname("Tegg");
		robin.setCurrentHandicap(15);
		playerRepository.save(robin);

		Player foist = new Player();
		foist.setFirstName("Richard");
		foist.setSurname("Foister");
		foist.setCurrentHandicap(12);
		playerRepository.save(foist);

		Player mad = new Player();
		mad.setFirstName("Andrew");
		mad.setSurname("Stevens");
		mad.setCurrentHandicap(28);
		playerRepository.save(mad);

		Player damo = new Player();
		damo.setFirstName("Damien");
		damo.setSurname("Kiernander");
		damo.setCurrentHandicap(18);
		playerRepository.save(damo);

		RaceToCiaoBella raceToCiaoBella = new RaceToCiaoBella();
		raceToCiaoBella.setSeason(2016);
		Set<Tournament> tournaments = new HashSet<>();
		addOther(theAddington, tom, dave, foist, mad, damo, tournaments);
		addShirley(shirleyPark, tom, dave, brad, robin, tournaments);

		raceToCiaoBella.setTournaments(tournaments);
		raceToCiaoBellaRepository.save(raceToCiaoBella);

		NewsItem item1 = new NewsItem();
		item1.setTitle("Apperley storms to top of leaderboard");
		item1.setSummary(
				"Thomas Apperley shows strong will power to take the lead as David Tryhorn slumps to fourth place");
		item1.setImageUrl("http://cdn.gdol.com/app/courses/image/preview/56855.jpg");
		item1.setLink("http://localhost:8080/racetociaobella/rounds/2");
		item1.setTag(RaceToCiaoBellaConstants.NEWS_ITEM_TAG);
		newsItemRepository.save(item1);

	}

	private void addOther(Venue venue, Player tom, Player dave, Player foist, Player mad, Player damo,
			Set<Tournament> tournaments) {
		Tournament shirley = new Tournament();
		shirley.setName("The Apperley Autumn Invitational");
		shirley.setDate(DateUtils.create(2015, 10, 24).getTime());
		shirley.setVenue(venue);
		Set<Result> results = new HashSet<>();

		Result tomResult = new Result();
		tomResult.setPlayer(tom);
		tomResult.setHandicap(tom.getCurrentHandicap());
		tomResult.setScore(28);
		results.add(tomResult);

		Result daveResult = new Result();
		daveResult.setPlayer(dave);
		daveResult.setHandicap(dave.getCurrentHandicap());
		daveResult.setScore(31);
		results.add(daveResult);

		Result bradResult = new Result();
		bradResult.setPlayer(foist);
		bradResult.setHandicap(foist.getCurrentHandicap());
		bradResult.setScore(32);
		results.add(bradResult);

		Result robinResult = new Result();
		robinResult.setPlayer(mad);
		robinResult.setHandicap(mad.getCurrentHandicap());
		robinResult.setScore(30);
		results.add(robinResult);

		Result damoResult = new Result();
		damoResult.setPlayer(damo);
		damoResult.setHandicap(damo.getCurrentHandicap());
		damoResult.setScore(24);
		results.add(damoResult);

		shirley.setResults(results);
		tournaments.add(shirley);
	}

	private void addShirley(Venue venue, Player tom, Player dave, Player brad, Player robin,
			Set<Tournament> tournaments) {
		Tournament shirley = new Tournament();
		shirley.setName("Stableford and Wine Invitational");
		shirley.setDate(DateUtils.create(2015, 12, 29).getTime());
		shirley.setVenue(venue);
		Set<Result> results = new HashSet<>();

		Result tomResult = new Result();
		tomResult.setPlayer(tom);
		tomResult.setHandicap(tom.getCurrentHandicap());
		tomResult.setScore(34);
		results.add(tomResult);

		Result daveResult = new Result();
		daveResult.setPlayer(dave);
		daveResult.setHandicap(dave.getCurrentHandicap());
		daveResult.setScore(26);
		results.add(daveResult);

		Result bradResult = new Result();
		bradResult.setPlayer(brad);
		bradResult.setHandicap(brad.getCurrentHandicap());
		bradResult.setScore(30);
		results.add(bradResult);

		Result robinResult = new Result();
		robinResult.setPlayer(robin);
		robinResult.setHandicap(robin.getCurrentHandicap());
		robinResult.setScore(32);
		results.add(robinResult);

		shirley.setResults(results);
		tournaments.add(shirley);
	}
	
}
