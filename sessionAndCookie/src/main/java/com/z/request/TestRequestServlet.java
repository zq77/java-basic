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
		//�����Ӧ����Ϣ
		Object root = request.getAttribute("root");
		System.out.println(root);
		
		
		//�������
		System.out.println("ת��������....");
		PrintWriter out = response.getWriter();  //����ֵ���õ�servletʹ�õ�����ͬ
		out.print("ҳ��ת��������....");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
