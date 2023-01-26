package com.z.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaxLengthServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		StringBuffer buf = new StringBuffer();
//1024是一个字节，也就是1kb，cookie的value最多放4kb
		for(int i = 0 ; i < 1024 * 5 ; i ++){
			buf.append("a");
		}
		
		String data = buf.toString();
		
		
		Cookie cookie = new Cookie("max",data);
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		
		

	}

}
