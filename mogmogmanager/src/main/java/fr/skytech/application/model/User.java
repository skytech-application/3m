package fr.skytech.application.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@OneToMany
	private Set<User> friends;
	
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
	public Set<User> getFriends() {
		if(friends==null){
			friends=new HashSet<User>();
		}
		return friends;
	}
	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	
	
}
