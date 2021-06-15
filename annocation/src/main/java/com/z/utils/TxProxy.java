package com.z.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

/**
 * 对事务进行代理，控制conn的提交
 * 通过注解控制开关
 * @author z
 *
 */
public class TxProxy implements InvocationHandler {
	/**
	 * 声明被代理类
	 */
	private Object target;
	/**
	 * 构造 中接收这个被代理的对象
	 */
	public TxProxy(Object o) {
		target = o;
	}
	
	/**
	 * 提供一个静态方法返回代理对象
	 * @param target	被代理对象,必须是final
	 * @return	代理的对象
	 */
	public static Object createProxy(final Object target) {
		Object o = Proxy.newProxyInstance(TxProxy.class.getClassLoader(), 
				target.getClass().getInterfaces(), //代理类实现的接口
				new TxProxy(target));
		return o;
	}

	/**
	 * 实现执行拦截方法
	 * 在这儿是管理事务的关键
	 * 依赖注解事项
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(">>>>>>>执行" + method.getName());
		if(!method.isAnnotationPresent(Transient.class)) {
			return method.invoke(target, args);
		}
		
		Connection conn = C3p0Utils.getThreadConnection();
		Object returnValue = null;
		try {
			//第三步：设置事务的开始
			conn.setAutoCommit(false);
			//第四步：调用目标类(被代理类)的方法
			returnValue = method.invoke(target, args);
			//第五步：调用如果成功提交
			conn.commit();
		} catch(Exception e) {
			System.out.println("============调用不成功回滚=============");
			conn.rollback();
			throw e;
		} finally {
			conn.close();
			C3p0Utils.remove();
		}
		
		return returnValue;//继续执行被代理对象的方法
	}
	
}
