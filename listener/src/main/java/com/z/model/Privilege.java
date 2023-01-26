package com.z.model;

import java.util.HashSet;
import java.util.Set;

public class Privilege {
	private String id;
	private String name;
	private String url;
	
	private Set<Role> roles = new HashSet<Role>();

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
