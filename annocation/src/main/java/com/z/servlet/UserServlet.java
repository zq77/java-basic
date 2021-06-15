package com.z.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see BaseServlet#BaseServlet()
     */
    public UserServlet() {
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
    	String name = request.getParameter("name");
    	System.out.println(name);
    	try {
			PrintWriter out = response.getWriter();
			out.print(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
