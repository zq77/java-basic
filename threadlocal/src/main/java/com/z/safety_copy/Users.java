package com.z.safety_copy;

public class Users {
	private String[] names;

	public Users(String[] name) {
//		this.names = name;	//舍弃，因为不安全
		names = new String[name.length];
		for(int i = 0; i < name.length; i ++) {
			this.names[i] = name[i];
		}
	}
	
	public void show() {
		for(String s : names) {
			System.out.println(s);
		}
	}
	
}
