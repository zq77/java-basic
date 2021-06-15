package com.z.utils;

import java.util.Random;

public class ThreadLocalUtils {
	//声明一个唯一的ThreadLocal
	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
	
	public static Object getObject() {
		//先从threadLocal中读取数据
		Object o = threadLocal.get();// 如果没有保存过，map.get(Thread.currentThread());
		
		if(o == null) {
			//生成一个随机
			o = new Random().nextInt(100);
			threadLocal.set(o);
		}
		
		return o;
	}
}
