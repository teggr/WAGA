package org.waga.rtcb;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RaceToCiaoBellaStatsServiceTest {

	@Test
	public void testTop4ResultsAreChosen() {
		
		List<Integer> totals = new ArrayList<>();
		
		totals.add(25);
		totals.add(33);
		totals.add(41);
		totals.add(33);
		totals.add(38);
		totals.add(29);
		totals.add(21);
		totals.add(15);
		
		int sum = totals.stream().sorted((t1, t2) -> t2.compareTo(t1)).limit(4).mapToInt(Integer::intValue).sum();
		
		assertEquals(145, sum);
		
	}
	
	@Test
	public void testTop3ResultsAreChosen() {
		
		List<Integer> totals = new ArrayList<>();
		
		totals.add(25);
		totals.add(33);
		totals.add(41);
		
		int sum = totals.stream().sorted((t1, t2) -> t2.compareTo(t1)).limit(4).mapToInt(Integer::intValue).sum();
		
		assertEquals(99, sum);
		
	}

}
