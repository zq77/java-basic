package com.z.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z.base.BaseServlet;
import com.z.model.Privilege;
import com.z.model.User;
import com.z.service.UserService;

public class UserServlet extends BaseServlet {

	//登录用的
	public void login(HttpServletRequest req, HttpServletResponse resp) {
		try {
//			System.out.println(req);
			String name = req.getParameter("name");
//System.out.println(name);
			String password = req.getParameter("password");
			User u = new User();
			u.setName(name);
			u.setPassword(password);
			User user = UserService.newInstance().existUser(u);
			if(user != null) {
				req.getSession().removeAttribute("loginErr"); //移除session中的loginErr
				req.getSession().setAttribute("user", user);
				List<Privilege> privileges = UserService.newInstance().privilegeList(user);
				//封装到req
				req.setAttribute("privileges", privileges);
				//实现跳转
				//resp.sendRedirect(req.getContextPath() + "/admin/index.jsp");
				req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
			} else {
//失败的话就跳转到登录页面
				req.getSession().setAttribute("loginErr", "用户名或密码错误");
				resp.sendRedirect(req.getContextPath() + "/loginUI.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 注销用的
	 */
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("用户退出");
		req.getSession().removeAttribute("user");
		try {
			resp.sendRedirect(req.getContextPath() + "/loginUI.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.sendRedirect(req.getContextPath() + "/loginUI.jsp");
//System.out.println("执行了execute");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
