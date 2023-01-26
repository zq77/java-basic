package com.z.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 用来记录当前的点击量
 * @author z
 *
 */
public class CountFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//获取application
		ServletContext app = req.getSession().getServletContext();
		
		Integer number = (Integer) app.getAttribute("number");
		if(number == null) {
			number = 1;
		} else {
			++ number;
		}
		
		app.setAttribute("number", number);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
