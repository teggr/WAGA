package org.waga.news;

import java.util.Date;

public class NewsItem {

	private String imageUrl;
	private String title;
	private String summary;
	private String link;
	private String tag;
	private Date createdTime;
	
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "NewsItem [imageUrl=" + imageUrl + ", title=" + title + ", summary=" + summary + ", link=" + link
				+ ", tag=" + tag + ", createdTime=" + createdTime + "]";
	}

}
