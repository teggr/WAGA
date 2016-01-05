package org.waga.news;

import javax.persistence.Entity;

import org.waga.core.AbstractEntity;

@Entity
public class NewsItem extends AbstractEntity {

	private String title;
	private String summary;
	private String imageUrl;
	private String link;
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String description) {
		this.summary = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "NewsItem [title=" + title + ", summary=" + summary + ", imageUrl=" + imageUrl + ", link=" + link
				+ ", tag=" + tag + "]";
	}

	public void update(NewsItem newsItem) {
		this.title = newsItem.title;
		this.summary = newsItem.summary;
		this.imageUrl = newsItem.imageUrl;
		this.tag = newsItem.tag;
		this.link = newsItem.link;
	}

}
