package org.waga.woodmancup;

import java.util.ArrayList;
import java.util.List;

import org.waga.woodmancup.tournaments.Abbotsley;
import org.waga.woodmancup.tournaments.Belfry;
import org.waga.woodmancup.tournaments.Bidford;
import org.waga.woodmancup.tournaments.Donnington;
import org.waga.woodmancup.tournaments.Dorset;
import org.waga.woodmancup.tournaments.EssexGc;
import org.waga.woodmancup.tournaments.Hastings;
import org.waga.woodmancup.tournaments.ManorOfGroves;
import org.waga.woodmancup.tournaments.OldThorns;
import org.waga.woodmancup.tournaments.Oxfordshire;
import org.waga.woodmancup.tournaments.Staverton;

public class WoodmanCupEvents {

	public static List<WoodmanCupEvent> events() {

		List<WoodmanCupEvent> list = new ArrayList<>();

		Oxfordshire.oxfordshire(list);
		Belfry.belfry(list);
		EssexGc.essecgc(list);
		ManorOfGroves.manorofgroves(list);
		Staverton.staverton(list);
		OldThorns.oldthorns(list);
		Donnington.donnington(list);
		Hastings.hastings(list);
		Abbotsley.abbotsley(list);
		Dorset.dorset(list);
		Bidford.bidford(list);

		return list;

	}

}
