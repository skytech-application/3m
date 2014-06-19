package fr.skytech.application.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDto extends ControllerResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3891014325611047517L;

	Long id;
	String username;
	String password;
	String email;
	Date subscribeDate;
	boolean enabled;
	RoleDto role;
	Integer xp;
	List<FriendDto> friends;

	public String getEmail() {
		return this.email;
	}

	public List<FriendDto> getFriends() {
		return this.friends;
	}

	public Long getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public RoleDto getRole() {
		return this.role;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd,HH:00", timezone = "CET")
	public Date getSubscribeDate() {
		return this.subscribeDate;
	}

	public String getUsername() {
		return this.username;
	}

	public Integer getXp() {
		return this.xp;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public void setFriends(final List<FriendDto> friends) {
		this.friends = friends;
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

	public void setSubscribeDate(final Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setXp(final Integer xp) {
		this.xp = xp;
	}

}
