package com.z.model;

import java.util.Date;

public class User {
	private String id;
	private String name;
	private int age;
	private Date birth;
	private String time;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Date getBirth() {
		return birth;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age
				+ ", birth=" + birth + ", time=" + time + "]";
	}
	
}
