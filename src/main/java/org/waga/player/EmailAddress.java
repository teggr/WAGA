package org.waga.player;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.StringUtils;

@Embeddable
public class EmailAddress {

	@Column(name = "EMAIL_ADDRESS")
	private String address;

	public String getAddress() {
		return address;
	}

	public boolean isNotEmpty() {
		return !StringUtils.isEmpty(address);
	}

}
