package org.waga.woodmancup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.waga.woodmancup.tournaments.Abbotsley2007;
import org.waga.woodmancup.tournaments.Belfry2014;
import org.waga.woodmancup.tournaments.Bidford2005;
import org.waga.woodmancup.tournaments.Donnington2009;
import org.waga.woodmancup.tournaments.Dorset2006;
import org.waga.woodmancup.tournaments.EssexGc2013;
import org.waga.woodmancup.tournaments.Hastings2008;
import org.waga.woodmancup.tournaments.ManorOfGroves2012;
import org.waga.woodmancup.tournaments.OldThorns2010;
import org.waga.woodmancup.tournaments.Oxfordshire2015;
import org.waga.woodmancup.tournaments.Staverton2011;

public class WoodmanCupEvents {

	public static List<WoodmanCupEvent> getEvents() {

		List<WoodmanCupEventDataProvider> providers = Arrays.asList(
				new EastSussex2016(),
				new Oxfordshire2015(), 
				new Belfry2014(), 
				new EssexGc2013(),
				new ManorOfGroves2012(), 
				new Staverton2011(), 
				new OldThorns2010(), 
				new Donnington2009(), 
				new Hastings2008(),
				new Abbotsley2007(), 
				new Dorset2006(), 
				new Bidford2005());

		List<WoodmanCupEvent> list = new ArrayList<>();
		for (WoodmanCupEventDataProvider provider : providers) {
			provider.registerEvent(list);
		}

		return list;

	}

}
