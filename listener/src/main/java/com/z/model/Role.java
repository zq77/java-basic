package com.z.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private String id;
	private String name;
	private String description;
	
	private Set<User> user = new HashSet<User>();
	private Set<Privilege> privileges = new HashSet<Privilege>();
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Set<User> getUser() {
		return user;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
