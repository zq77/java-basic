package com.z.cookie.path;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//添加cookie  /addCookieServlet
		
		// * 创建cookie
		Cookie cookie = new Cookie("add111","1111111111111");
		// * 设置有效时间
		cookie.setMaxAge(60*60);
		// * 通知浏览器
		response.addCookie(cookie);
		
		

	}

}