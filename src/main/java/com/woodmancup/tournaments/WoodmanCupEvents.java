package com.woodmancup.tournaments;

import java.util.ArrayList;
import java.util.List;

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
