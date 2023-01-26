package com.z.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetAgeCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=GBK");
		
		PrintWriter out = resp.getWriter();
		//�������������cookie��Ϣ
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				out.print(c.getName() + " :��" + c.getValue() + "<br/>");
			}
		} else {
			out.print("û��cookie");
		}

		
		//����cookie
		Cookie cookie = new Cookie("login","z");
		//����cookie����Чʱ�䣬ʹ�Ự��cookie��ɳ־û�cookie
		cookie.setMaxAge(60 * 2);
		
System.out.println("cookie�Ѵ洢");		
		//��cookie��Ϣ֪ͨ�����
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
