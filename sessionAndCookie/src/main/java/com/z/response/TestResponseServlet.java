package com.z.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestResponseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//��ȡ
		
		Object pwd = request.getAttribute("pwd");
		System.out.println(pwd);
		
		System.out.println("�ض��������....");
		PrintWriter out = response.getWriter();  //����ֵ���õ�servletʹ�õ�����ͬ
		out.print("ҳ���ض��������....");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

