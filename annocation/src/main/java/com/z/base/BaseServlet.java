package com.z.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BaseServlet() {
    }

	/**
	 * this指的是继承BaseServlet的子类，因为BaseServlet是抽象类
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null || action.trim().length()==0) {
			this.execute(request, response);
		} else {
			try {
				Method m = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
				m.invoke(this, request, response);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 这个是用来如果有用户不输入action的值的话就执行这个抽象方法
	 * @param request
	 * @param response
	 */
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
