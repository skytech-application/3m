package fr.skytech.application.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3891014325611047517L;

	Long id;
	String username;

	public Long getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}
