package org.waga.news;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsItemRepository extends JpaRepository<NewsItem, Long> {

	List<NewsItem> findFirst10ByOrderByCreatedDateDesc();

	List<NewsItem> findFirst10ByTagOrderByCreatedDateDesc(String tag);

}
