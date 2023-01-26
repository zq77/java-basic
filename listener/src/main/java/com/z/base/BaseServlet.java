package com.z.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
//		System.out.println(action);
		if(action == null || action.equals("")) {
			this.execute(req, resp);
		} else {
			try {
				//下面两行代码中的参数必须这样写
				Method method = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
				method.invoke(this, req, resp);
				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 当传递过来的action为空的时候执行的方法
	 * @param req
	 * @param resp
	 */
	public abstract void execute(HttpServletRequest req, HttpServletResponse resp);
}
