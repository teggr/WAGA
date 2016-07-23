package org.waga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.waga.player.Player;
import org.waga.player.Players;
import org.waga.rtcb.RaceToCiaoBella;
import org.waga.rtcb.Result;
import org.waga.rtcb.Tournament;
import org.waga.venue.Venues;

public class WagaDataCompiler {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static WagaData compile() {
		
		return new AggregatedWagaData();
		
	}
	
	public List<RaceToCiaoBella> getEvents() {
		List<RaceToCiaoBella> list = new ArrayList<>();
		
		RaceToCiaoBella bella = new RaceToCiaoBella();
		bella.setSeason(2016);
		
		aai(bella);
		stablefordAndWine(bella);
		febex(bella);
		aprilFool(bella);
		foxhillFancy(bella);
		slipperySilvermere(bella);
		
		list.add(bella);
		
		return list;
	}

	private void aai(RaceToCiaoBella bella) {
		Tournament tour = new Tournament();
		tour.setName("Apperley Autumn Invitational (AAI)");
		tour.setDate(asDate("2015-07-16"));
		tour.setVenue(Venues.addington.asVenue());
		addResult( Players.foist.asPlayer(), 32, tour );
		addResult( Players.snakes.asPlayer(), 31, tour );
		addResult( Players.maddog.asPlayer(), 30, tour );
		addResult( Players.apps.asPlayer(), 28, tour );
		addResult( Players.damo.asPlayer(), 24, tour );
		bella.addTournaments(tour);
	}
	
	private void addResult(Player player, int points, Tournament tour) {
	 Result result = new Result();
	 result.setHandicap(player.getCurrentHandicap());
	 result.setScore(points);
	 result.setPlayer(player);
	 tour.addResult(result);
	}

	private Date asDate(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
