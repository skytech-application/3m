package fr.skytech.application.controller.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3891014325611047517L;
	
	Long id;
	String username;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
