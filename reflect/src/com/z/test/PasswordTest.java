package com.z.test;

import java.lang.reflect.Method;

public class PasswordTest {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("Password");
		Method[] methods = c.getMethods();
		for(Method m : methods) {
			Class cl = m.getReturnType();
		System.out.println(cl);
		}
	}
}
