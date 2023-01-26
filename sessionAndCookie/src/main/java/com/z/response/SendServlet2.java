package com.z.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//重定向  --重新确定请求方向
		String url = "testResponseServlet";
		PrintWriter out = response.getWriter();
		
		System.out.println("Send前");
		out.print("页面Send前<br/>"); 
		
		//重定向之前设置值
		request.setAttribute("pwd", "1234");
		
		response.sendRedirect(url);
		
		out.print("页面Send后<br/>"); 
		System.out.println("Send后");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
