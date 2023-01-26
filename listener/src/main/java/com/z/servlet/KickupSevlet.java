package com.z.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KickupSevlet extends HttpServlet {

	/**
	 * 用来剔除当前在线用户的
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("踢出的sessionid："+id);
		
		Map<String,HttpSession> map = (Map<String, HttpSession>)getServletContext().getAttribute("online");
		//得到当前要删除的session，将其完全销毁
		HttpSession session = map.get(id);
		session.invalidate();
		//重定向到
		response.sendRedirect(request.getContextPath()+"/admin/showUserServlet");
	}

}
