package com.z.test;

import org.junit.Test;

import com.z.myThreadLocal.MyThreadLocal;

import com.z.utils.ThreadLocalUtils;

public class TestThreadLocal {

	/**
	 * 测试java本身的ThreadLocal类
	 */
	@Test
	public void testThreadLocal() throws InterruptedException {
		ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
		//保存数据
		threadLocal.set("Hello");
		Object o = threadLocal.get();
		Object o2 = threadLocal.get();
		
		new Thread() {

			@Override
			public void run() {
				ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();
				Object o3 = threadLocal.get();
				Object o4 = threadLocal.get();
				System.out.println(o3 + " : " + o4);
			}
		}.start();
		
		Thread.sleep(1000);
		
		System.out.println(o + " : " + o2);
	}
	
	/**
	 * 使用工具类测试java本身的ThreadLocal类
	 */
	@Test
	public void testThreadLocalUtils() throws InterruptedException {

		Object o = ThreadLocalUtils.getObject();
		Object o2 = ThreadLocalUtils.getObject();
		
		Thread thread = new Thread() {

			@Override
			public void run() {
				Object o3 = ThreadLocalUtils.getObject();
				Object o4 = ThreadLocalUtils.getObject();
				System.out.println(o3 + " : " + o4);
			}
		};

		thread.start();
		
		Thread.sleep(1000);
		
		System.out.println(o + " : " + o2);
	}
	
	/**
	 * 测试我们自己编写的MyThreadLocal类
	 */
	@Test
	public void testMyThreadLocal() throws InterruptedException {
		Object o = MyThreadLocal.getObject();
		Object o2 = MyThreadLocal.getObject();
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				Object o3 = MyThreadLocal.getObject();
				Object o4 = MyThreadLocal.getObject();
				System.out.println(Thread.currentThread().getName() + " : "  + o3 + " : " + o4);
			}
		};
		thread.start();
		
		Thread.sleep(1000);
		
		
		System.out.println(Thread.currentThread().getName() + " : " + o + " : " + o2);
	}
}
