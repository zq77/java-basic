package com.z.cookie.path;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//添加cookie   /cookie/addCookieServlet2
		
		//将当前servlet设置的cookie ，只能在cookie目录下的所有servlet以及之后的servlet中可以获得
		//想在  /getCookieServlet 中访问？
		
		
		// * 创建cookie
		Cookie cookie = new Cookie("add222","22222222222");
		// * 设置有效时间
		cookie.setMaxAge(60*60);
		// * 修改路径
		cookie.setPath("/session&cookie/");
		// * 通知浏览器
		response.addCookie(cookie);

	}

}
