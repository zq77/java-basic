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
		//�ض���  --����ȷ��������
		String url = "testResponseServlet";
		PrintWriter out = response.getWriter();
		
		System.out.println("Sendǰ");
		out.print("ҳ��Sendǰ<br/>"); 
		
		//�ض���֮ǰ����ֵ
		request.setAttribute("pwd", "1234");
		
		response.sendRedirect(url);
		
		out.print("ҳ��Send��<br/>"); 
		System.out.println("Send��");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
