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
		//ת��  -- ��ǰ����δ���
		
		// * ������������
		/*
		 * ����:
		 * ��ǰҳ�棺http://localhost:8080/day07/requestDispatcherServlet
		 * Ŀ��ҳ�棺http://localhost:8080/day07/testRequestServlet
		 * / -- context root --> WebRoot  --> tomcat/webapps/day07
		 */
//		RequestDispatcher dispatcher = request.getRequestDispatcher("testRequestServlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/testRequestServlet");
		
		//��Ҫ�����ݷ��͵������
		PrintWriter out = response.getWriter();
		
		System.out.println("ת��ǰ");
		out.print("ҳ��ת��ǰ<br/>");  //û�з��͵������
		// * ת������  -- ���÷������˵�һ������
		
		// ��ת��֮ǰ����request������ֵ
		request.setAttribute("root", "123456");
		System.out.println(request);
		dispatcher.forward(request, response);  //��ʾ���һ�����������
//		dispatcher.include(request, response);  //�ϲ���ǰ���е�ִ��ҳ����������
		out.print("ҳ��ת����<br/>"); //û�з��͵������
		System.out.println("ת����");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
