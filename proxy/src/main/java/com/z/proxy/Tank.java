package com.z.proxy;

import java.util.Random;
//委托对象，也就是被代理对象
public class Tank implements Moveable {

	@Override
	public void move() {
		System.out.println(" Tank move !");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		System.out.println(" Tank stop !");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
