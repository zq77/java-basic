package com.z.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//重定向  -- 服务器通知浏览器，重新发送请求
		//参数：确定重新发送的URL，建议使用绝对(完整) http://localhost:8080/  -- http://www.baidu.com
		// * 1.html  --> http://localhost:8080/day07/1.html
		String url = "http://localhost:8080/session&cookie/index.jsp";
		/* 确定，当前页面与目标页面时两次请求
		 * 当前页面：http://localhost:8080/day07/sendServlet
		 * 目标页面：http://localhost:8080/day07/1.html
		 */
//		String url = "1.html";
//		String url = "/day07/1.html";
//		String url = "./1.html";
//		String url = "../day07/1.html";
		resp.sendRedirect(url);
		//完全等价，隐藏了HTTP协议的具体要求
		//跳转
		//resp.setStatus(302);
		//resp.setHeader("location", "http://localhost:8080/day07/1.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
