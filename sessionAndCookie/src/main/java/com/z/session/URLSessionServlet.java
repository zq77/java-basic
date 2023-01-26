package com.z.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class URLSessionServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获得session
		HttpSession session = request.getSession();
		System.out.println("urlsession " + session.getId());
		
		String url = "sessionServlet";
		
		/* 当前页面：http://localhost:8080/day07/urlSessionServlet
		 * 目标页面：http://localhost:8080/day07/urlSessionServlet2
		 */
		//ＵＲＬ重写
		url = response.encodeURL(url);   //处理：如果需要sessionId，则在URL中追加
		
		this.getServletContext().getRealPath(""); //获得真实的路径  web项目 / WebRoot
		
		
		//将此链接，以a标签的输出
		PrintWriter out = response.getWriter();
		out.print("<a href='"+url+"'>SessionServlet</a>");
		out.close();
		
		//持久化
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		//设置有效时间
		cookie.setMaxAge(60*30);
		//通知浏览器
		response.addCookie(cookie);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


}
