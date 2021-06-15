package com.z.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 这个c3p0的工具类需要和ThreadLocal结合一下
 * @author z
 *
 */
public class C3p0Utils {

	private static DataSource dataSource;
	//声明一个唯一的ThreadLocal
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static {
		try {
			dataSource = new ComboPooledDataSource();//默认的读取c3p0-config.xml中默认配置
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 得到数据源
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 得到链接
	 */
	public static Connection getConnection() {
		//先从threadLocal中读取数据
		Connection conn = threadLocal.get();
		if(conn == null) {
			try {
				conn = dataSource.getConnection();//每一次从数据源中获取一个新的连接
				threadLocal.set(conn);//将这个链接放到map中，map的键是当前请求的线程
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/**
	 * 从ThreadLocal中删除conn
	 */
	public static void remove() {
		threadLocal.remove();
	}
}
