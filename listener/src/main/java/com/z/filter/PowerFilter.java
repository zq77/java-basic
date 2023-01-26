package com.z.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.z.model.User;
import com.z.service.UserService;

/**
 * 这是一个权限过滤器，用来过滤权限的
 * @author z
 *
 */
public class PowerFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取uri
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		uri = uri.replaceAll(req.getContextPath(), "");
//System.out.println(uri);
		if(uri.contains("/admin/index.jsp")) {
			chain.doFilter(request, response);
		} else {
			if(UserService.newInstance().checkPrivilege((User)req.getSession().getAttribute("user"),uri) == 0) {
				System.out.println("你没有权限....");
			} else {
				chain.doFilter(request, response);
			}
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
