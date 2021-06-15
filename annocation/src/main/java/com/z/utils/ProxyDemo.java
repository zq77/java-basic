package com.z.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 书写代理的示例,可以对所有的类进行代理
 * 要实现接口InvocationHandler,即可以生成代理类，也可以修改被代理类的方法
 * @author z
 *
 */
public class ProxyDemo implements InvocationHandler {
	/**
	 * 声明被代理类
	 */
	private Object target;
	/**
	 * 构造 中接收这个被代理的对象
	 */
	public ProxyDemo(Object o) {
		target = o;
	}
	
	/**
	 * 提供一个静态方法返回代理对象
	 * @param target	被代理对象,必须是final
	 * @return	代理的对象
	 */
	public static Object createProxy(final Object target) {
		Object o = Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), 
				target.getClass().getInterfaces(), //代理类实现的接口
				new ProxyDemo(target));
		return o;
	}

	/**
	 * 实现执行拦截方法
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("执行" + method.getName());
		return method.invoke(target, args);//继续执行被代理对象的方法
	}
	
}
