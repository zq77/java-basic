package com.z.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestRequestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(request);
		//获得相应的信息
		Object root = request.getAttribute("root");
		System.out.println(root);
		
		
		//输出内容
		System.out.println("转发调用中....");
		PrintWriter out = response.getWriter();  //必须值调用的servlet使用的流相同
		out.print("页面转发调用中....");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
