package org.waga.news;

import java.util.List;

public interface NewsItemRepository {

	List<NewsItem> findFirst10ByCreatedDateDesc();

}
