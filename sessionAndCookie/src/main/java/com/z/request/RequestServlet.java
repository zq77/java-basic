package com.z.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//转发  -- 当前请求未完成
		
		// * 获得请求调度器
		/*
		 * 参数:
		 * 当前页面：http://localhost:8080/day07/requestDispatcherServlet
		 * 目标页面：http://localhost:8080/day07/testRequestServlet
		 * / -- context root --> WebRoot  --> tomcat/webapps/day07
		 */
//		RequestDispatcher dispatcher = request.getRequestDispatcher("testRequestServlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/testRequestServlet");
		
		//需要将数据发送的浏览器
		PrintWriter out = response.getWriter();
		
		System.out.println("转发前");
		out.print("页面转发前<br/>");  //没有发送到浏览器
		// * 转发操作  -- 调用服务器端的一个方法
		
		// 在转发之前，在request中设置值
		request.setAttribute("root", "123456");
		System.out.println(request);
		dispatcher.forward(request, response);  //显示最后一个输出的内容
//		dispatcher.include(request, response);  //合并当前所有的执行页面的输出内容
		out.print("页面转发后<br/>"); //没有发送到浏览器
		System.out.println("转发后");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
