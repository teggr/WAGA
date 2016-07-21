package org.waga.player;

import org.springframework.util.StringUtils;

public class EmailAddress {

	private String address;

	public String getAddress() {
		return address;
	}

	public boolean isNotEmpty() {
		return !StringUtils.isEmpty(address);
	}

}
