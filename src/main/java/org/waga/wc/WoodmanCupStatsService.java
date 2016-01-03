package org.waga.wc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WoodmanCupStatsService {

	public List<WoodmanCupLeader> getLeaders() {
		
		WoodmanCupLeader leader = new WoodmanCupLeader();
		leader.setPlayed(2);
		leader.setPlayer("Tom Apperley");
		leader.setPosition(1);
		leader.setPoints(60);

		return Arrays.asList(leader);
	}

}
