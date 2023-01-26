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
 * 用来控制conn实现事务的提交
 * @author z
 *
 */
public class ThreadFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//System.out.println(Thread.currentThread());
		Connection conn = C3p0Utils.getThreadConnection();
		try {
			//将conn弄成不自动提交
			conn.setAutoCommit(false);
			//放行
			chain.doFilter(request, response);
			
			//如果没有出错。
			conn.commit();
		} catch (Exception e) {
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
			if(conn != null) {
				try {
					conn.close();
					C3p0Utils.remove();// 还要将threadLocal中的conn删除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
