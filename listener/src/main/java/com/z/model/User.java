package com.z.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 需要序列化才能将user放到文件中
 * @author z
 *
 */
public class User implements Serializable,HttpSessionActivationListener {

	private String id;
	private String name;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void sessionDidActivate(HttpSessionEvent e) {
		System.err.println("从文件中活化了...."+this.getName());
	}
	public void sessionWillPassivate(HttpSessionEvent e) {
		System.err.println("保存到文件中去了..."+this.getName());
	}
}
