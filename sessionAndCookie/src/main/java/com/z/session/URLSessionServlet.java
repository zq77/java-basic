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
		//���session
		HttpSession session = request.getSession();
		System.out.println("urlsession " + session.getId());
		
		String url = "sessionServlet";
		
		/* ��ǰҳ�棺http://localhost:8080/day07/urlSessionServlet
		 * Ŀ��ҳ�棺http://localhost:8080/day07/urlSessionServlet2
		 */
		//�գң���д
		url = response.encodeURL(url);   //���������ҪsessionId������URL��׷��
		
		this.getServletContext().getRealPath(""); //�����ʵ��·��  web��Ŀ / WebRoot
		
		
		//�������ӣ���a��ǩ�����
		PrintWriter out = response.getWriter();
		out.print("<a href='"+url+"'>SessionServlet</a>");
		out.close();
		
		//�־û�
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		//������Чʱ��
		cookie.setMaxAge(60*30);
		//֪ͨ�����
		response.addCookie(cookie);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


}
