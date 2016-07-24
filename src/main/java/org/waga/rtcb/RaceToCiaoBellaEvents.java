package org.waga.rtcb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.venue.Venues;

public class RaceToCiaoBellaEvents {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static List<RaceToCiaoBella> getEvents() {
		List<RaceToCiaoBella> list = new ArrayList<>();

		RaceToCiaoBella bella = new RaceToCiaoBella(2016);

		aai(bella);
		stablefordAndWine(bella);
		febex(bella);
		foxhillFancy(bella);
		aprilFool(bella);
		slipperySilvermere(bella);

		list.add(bella);

		return list;
	}

	private static void slipperySilvermere(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("Snakey Dave's Slippery Silvermere Challenge");
		tour.setDate(asDate("2016-06-24"));
		tour.setVenue(Venues.silvermere.asVenue());
		addResult(Players.teggy.asPlayer(), 31, tour);
		addResult(Players.apps.asPlayer(), 30, tour);
		addResult(Players.foist.asPlayer(), 28, tour);
		addResult(Players.maddog.asPlayer(), 22, tour);
		addResult(Players.snakes.asPlayer(), 20, tour);
		bella.addTournament(tour);
	}

	private static void aprilFool(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("Maddog's April Fool");
		tour.setDate(asDate("2016-04-22"));
		tour.setVenue(Venues.hampton.asVenue());
		addResult(Players.foist.asPlayer(), 38, tour);
		addResult(Players.brad.asPlayer(), 36, tour);
		addResult(Players.teggy.asPlayer(), 35, tour);
		addResult(Players.apps.asPlayer(), 35, tour);
		addResult(Players.maddog.asPlayer(), 27, tour);
		bella.addTournament(tour);
	}

	private static void foxhillFancy(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("Foister's Foxhill Fancy");
		tour.setDate(asDate("2016-03-20"));
		tour.setVenue(Venues.foxhills.asVenue());
		addResult(Players.foist.asPlayer(), 32, tour);
		addResult(Players.brad.asPlayer(), 32, tour);
		addResult(Players.teggy.asPlayer(), 29, tour);
		addResult(Players.apps.asPlayer(), 29, tour);
		addResult(Players.damo.asPlayer(), 24, tour);
		addResult(Players.east.asPlayer(), 22, tour);
		bella.addTournament(tour);
	}

	private static void febex(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("The Febex");
		tour.setDate(asDate("2016-02-27"));
		tour.setVenue(Venues.selsdon.asVenue());
		addResult(Players.foist.asPlayer(), 36, tour);
		addResult(Players.apps.asPlayer(), 35, tour);
		addResult(Players.damo.asPlayer(), 32, tour);
		addResult(Players.maddog.asPlayer(), 30, tour);
		addResult(Players.brad.asPlayer(), 29, tour);
		addResult(Players.teggy.asPlayer(), 27, tour);
		bella.addTournament(tour);
	}

	private static void stablefordAndWine(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("Stableford and Wine invitational");
		tour.setDate(asDate("2015-11-16"));
		tour.setVenue(Venues.shirley.asVenue());
		addResult(Players.apps.asPlayer(), 34, tour);
		addResult(Players.teggy.asPlayer(), 32, tour);
		addResult(Players.brad.asPlayer(), 30, tour);
		addResult(Players.snakes.asPlayer(), 26, tour);
		bella.addTournament(tour);
	}

	private static void aai(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("Apperley Autumn Invitational (AAI)");
		tour.setDate(asDate("2015-07-16"));
		tour.setVenue(Venues.addington.asVenue());
		addResult(Players.foist.asPlayer(), 32, tour);
		addResult(Players.snakes.asPlayer(), 31, tour);
		addResult(Players.maddog.asPlayer(), 30, tour);
		addResult(Players.apps.asPlayer(), 28, tour);
		addResult(Players.damo.asPlayer(), 24, tour);
		bella.addTournament(tour);
	}

	private static void addResult(Player player, int points, Tournament tour) {
		Result result = new Result();
		result.setHandicap(player.getCurrentHandicap());
		result.setScore(points);
		result.setPlayer(player);
		tour.addResult(result);
	}

	private static Date asDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
