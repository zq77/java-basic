package com.z.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用包装,声明一个c3p0连接池的工具类
 * conn是使用threadLocal管理事务的
 * @author z
 *
 */
public class C3p0Utils {

	private static DataSource dataSource;
//使线程锁定conn，从而管理事务
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static {
		dataSource = new ComboPooledDataSource("annocation");//默认的读取c3p0-config.xml中默认配置
		
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
		Connection conn = null;
		try {
			conn = dataSource.getConnection();//每一次从数据源中获取一个新的连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 得到当前线程的链接
	 */
	public static Connection getThreadConnection() {
		Connection conn = threadLocal.get();
		if(conn == null) {
			try {
				conn = dataSource.getConnection();
				threadLocal.set(conn);// 将取得的conn和当前的线程放到threadLocal中
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return conn;
	}
	
	/**
	 * 当链接使用完成后要从threadLocal中remove
	 */
	public static void remove() {
		threadLocal.remove();
	}
}
