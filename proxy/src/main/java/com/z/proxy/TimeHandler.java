package com.z.proxy;

import java.lang.reflect.Method;


public class TimeHandler implements InvocationHandler {
	private Object target;
	
	public TimeHandler(Object target) {
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		long start = System.currentTimeMillis();
		System.out.println("starttime:" + start);
		System.out.println(o.getClass().getName());
		try {
			//这的invoke是反射，选取的是底层的类中的m方法
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start));
	}

}
