package com.z.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetAgeCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=GBK");
		
		PrintWriter out = resp.getWriter();
		//获得浏览器保存的cookie信息
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				out.print(c.getName() + " :　" + c.getValue() + "<br/>");
			}
		} else {
			out.print("没有cookie");
		}

		
		//创建cookie
		Cookie cookie = new Cookie("login","z");
		//设置cookie的有效时间，使会话级cookie变成持久化cookie
		cookie.setMaxAge(60 * 2);
		
System.out.println("cookie已存储");		
		//将cookie信息通知浏览器
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
