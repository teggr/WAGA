package org.waga;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.DateUtils;
import org.waga.news.NewsItem;
import org.waga.news.NewsItemRepository;
import org.waga.player.Player;
import org.waga.player.PlayerRepository;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.RaceToCiaoBellaConstants;
import org.waga.rtcb.RaceToCiaoBellaRepository;
import org.waga.rtcb.Result;
import org.waga.rtcb.Tournament;
import org.waga.venue.Venue;
import org.waga.venue.VenueRepository;

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

		Venue theAddington = new Venue();
		theAddington.setName("The Addington");
		theAddington.setImageUrl("http://www.nationalclubgolfer.com/articles/article/addington-12th%7Cc%3A520x330.jpg");
		theAddington.setLink("http://www.addingtongolf.com/");
		venueRepository.save(theAddington);

		Player tom = new Player();
		tom.setFirstName("Thomas");
		tom.setSurname("Apperley");
		tom.setCurrentHandicap(12);
		tom.setImageUrl("http://www.parforegolf.net/wp-content/uploads/2015/08/1.jpg");
		playerRepository.save(tom);

		Player dave = new Player();
		dave.setFirstName("David");
		dave.setSurname("Tryhorn");
		dave.setCurrentHandicap(23);
		dave.setImageUrl("http://www.hdnicewallpapers.com/Walls/Big/Golf/Player_Hit_the_Golf_Ball_Pics.jpg");
		playerRepository.save(dave);

		Player brad = new Player();
		brad.setFirstName("Brad");
		brad.setSurname("Le Riche");
		brad.setCurrentHandicap(28);
		brad.setImageUrl("http://www.golfersavenue.com/wp-content/uploads/2012/08/how-to-look-like-a-real-golf-player.jpg");
		playerRepository.save(brad);

		Player robin = new Player();
		robin.setFirstName("Robin");
		robin.setSurname("Tegg");
		robin.setCurrentHandicap(15);
		robin.setImageUrl("http://wpmedia.o.canada.com/2013/11/australia_world_cup_of_golf.jpg");
		playerRepository.save(robin);

		Player foist = new Player();
		foist.setFirstName("Richard");
		foist.setSurname("Foister");
		foist.setCurrentHandicap(12);
		foist.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/6/6e/Golfer_swing.jpg");
		playerRepository.save(foist);

		Player mad = new Player();
		mad.setFirstName("Andrew");
		mad.setSurname("Stevens");
		mad.setCurrentHandicap(28);
		mad.setImageUrl("http://helpingisraelfund.com/wp-content/uploads/2014/12/Tiger-Woods-best-golf-player-hd-posters1.jpg");
		playerRepository.save(mad);

		Player damo = new Player();
		damo.setFirstName("Damien");
		damo.setSurname("Kiernander");
		damo.setCurrentHandicap(18);
		damo.setImageUrl("http://garyplayer.com/images/uploads/news/GabonGolf.jpg");
		playerRepository.save(damo);

		RaceToCiaoBella raceToCiaoBella = new RaceToCiaoBella();
		raceToCiaoBella.setSeason(2016);
		raceToCiaoBella.setTournaments(new HashSet<>());
		raceToCiaoBella.addTournaments(aai(theAddington, tom, dave, foist, mad, damo));
		raceToCiaoBellaRepository.save(raceToCiaoBella);

		NewsItem item1 = new NewsItem();
		item1.setTitle("Apperley storms to top of leaderboard");
		item1.setSummary(
				"Thomas Apperley shows strong will power to take the lead as David Tryhorn slumps to fourth place");
		item1.setImageUrl("http://cdn.gdol.com/app/courses/image/preview/56855.jpg");
		item1.setLink("/racetociaobella");
		item1.setTag(RaceToCiaoBellaConstants.NEWS_ITEM_TAG);
		newsItemRepository.save(item1);

	}

	private Tournament aai(Venue venue, Player tom, Player dave, Player foist, Player mad, Player damo) {

		Tournament tournament = new Tournament();
		tournament.setResults(new HashSet<>());
		tournament.setName("The Apperley Autumn Invitational");
		tournament.setDate(DateUtils.create(2015, 10, 24).getTime());
		tournament.setVenue(venue);

		Result tomResult = new Result();
		tomResult.setPlayer(tom);
		tomResult.setHandicap(tom.getCurrentHandicap());
		tomResult.setScore(28);
		tournament.addResult(tomResult);

		Result daveResult = new Result();
		daveResult.setPlayer(dave);
		daveResult.setHandicap(dave.getCurrentHandicap());
		daveResult.setScore(31);
		tournament.addResult(daveResult);

		Result bradResult = new Result();
		bradResult.setPlayer(foist);
		bradResult.setHandicap(foist.getCurrentHandicap());
		bradResult.setScore(32);
		tournament.addResult(bradResult);

		Result robinResult = new Result();
		robinResult.setPlayer(mad);
		robinResult.setHandicap(mad.getCurrentHandicap());
		robinResult.setScore(30);
		tournament.addResult(robinResult);

		Result damoResult = new Result();
		damoResult.setPlayer(damo);
		damoResult.setHandicap(damo.getCurrentHandicap());
		damoResult.setScore(24);
		tournament.addResult(damoResult);

		return tournament;
	}

}
