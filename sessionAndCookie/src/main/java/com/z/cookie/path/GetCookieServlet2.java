package com.z.cookie.path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 获得cookie /cookie/getCookieServlet2

		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
System.out.println("cookie/getcookieservlet2");
		if (cookies != null) {
			for (Cookie c : cookies) {
				out.print("222222 --> " + c.getName() + " : " + c.getValue());
			}
		} else {
			out.print("没有222222 cookie");
		}

	}

}
