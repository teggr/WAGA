package org.waga.news;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InmemoryNewsItemRepository implements NewsItemRepository {

	@Override
	public List<NewsItem> findFirst10ByCreatedDateDesc() {

		NewsItem item1 = new NewsItem();

		item1.setTitle("Apperley storms to top of leaderboard");
		item1.setSummary(
				"Thomas Apperley shows strong will power to take the lead as David Tryhorn slumps to fourth place");
		item1.setImageUrl("http://www.munosconggolf.com/wp-content/uploads/2011/07/golf-swing-tips.jpg");
		item1.setLink("http://localhost:8080/racetociaobella/rounds/2");
		Date createdTime = new Date();
		item1.setCreatedTime(createdTime);
		item1.setTag("Race to Ciao Bella");

		return Arrays.asList(item1);
	}

}
