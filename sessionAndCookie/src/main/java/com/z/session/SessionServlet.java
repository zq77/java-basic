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
//服务器会先询问浏览器上的sessionid是否存在，存在就调用，不存在就建立一个session
		HttpSession session = req.getSession();
//输出为true就表示建立了新的session		
		System.out.println(session.isNew());
System.out.println("sessionServlet:" + session.getId());
		//持久化
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		//设置有效时间
		cookie.setMaxAge(60*30);
		//通知浏览器
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
