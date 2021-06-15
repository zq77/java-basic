package com.z.myThreadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 自己编写一个类用来模拟ThreadLocal
 * @author z
 *
 */
public class MyThreadLocal {

	private static Map<Object,Object> map = new HashMap<Object,Object>();
	
	public static Object getObject() {
		//map的键 是当前的线程
		Object o = map.get(Thread.currentThread());
		if(o == null) {
			o = new Random().nextInt(256);
			map.put(Thread.currentThread(), o);
		}
		return o;
	}
	
	public static void remove() {
		map.remove(Thread.currentThread());
	}
}
