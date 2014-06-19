package fr.skytech.application.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "enabled")
	private boolean enabled;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role", nullable = false)
	private Role role;

	@Column(name = "subscribeDate")
	@Temporal(TemporalType.DATE)
	private Date subscribeDate;

	@Column(name = "xp")
	private Integer xp;

	@ManyToMany
	@JoinTable(name = "user_follower", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "followerId"))
	protected List<User> followers;
	@ManyToMany(mappedBy = "followers")
	protected List<User> followed;

	public String getEmail() {
		return this.email;
	}

	public List<User> getFollowed() {
		return this.followed;
	}

	public List<User> getFollowers() {
		return this.followers;
	}

	public Long getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public Role getRole() {
		return this.role;
	}

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

	public void setFollowed(final List<User> followed) {
		this.followed = followed;
	}

	public void setFollowers(final List<User> followers) {
		this.followers = followers;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setRole(final Role role) {
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
