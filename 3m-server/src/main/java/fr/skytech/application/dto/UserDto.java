package fr.skytech.application.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3891014325611047517L;

	Long id;
	String username;
	String password;
	boolean enabled;
	RoleDto role;

	public Long getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public RoleDto getRole() {
		return this.role;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setRole(final RoleDto role) {
		this.role = role;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}
