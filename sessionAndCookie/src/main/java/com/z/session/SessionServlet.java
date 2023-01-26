package com.z.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
//����������ѯ��������ϵ�sessionid�Ƿ���ڣ����ھ͵��ã������ھͽ���һ��session
		HttpSession session = req.getSession();
//���Ϊtrue�ͱ�ʾ�������µ�session		
		System.out.println(session.isNew());
System.out.println("sessionServlet:" + session.getId());
		//�־û�
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		//������Чʱ��
		cookie.setMaxAge(60*30);
		//֪ͨ�����
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
