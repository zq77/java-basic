package com.z.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.z.utils.C3p0Utils;

/**
 * 在filter中写有关事务的管理
 * @author z
 *
 */
public class UserFilter implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Connection conn = C3p0Utils.getConnection();
System.out.println("filter conn is : " + conn);
System.out.println("filter thread is : " + Thread.currentThread().getName());
		//在try中开始事务
		try {
			//将conn弄成不自动提交
			conn.setAutoCommit(false);
			//放行
			chain.doFilter(request, response);
			
			//如果没有出错。
			conn.commit();
		} catch (Exception e) {
			System.out.println("出错了，要回滚");
			try {
				
				if(e instanceof SQLException) {
	//只有抛SQLException的时候才回滚，其他的异常照样执行提交				
						conn.rollback();
				} else {
					conn.commit();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			throw new RuntimeException(e);
		} finally {
			
			//最后不要忘记关闭,还要将链接从ThreadLocal中删除
			if (conn != null) {
				try {
					conn.close();
					C3p0Utils.remove();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
