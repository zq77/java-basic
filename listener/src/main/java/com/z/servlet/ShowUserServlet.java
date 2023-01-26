package com.z.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.z.model.User;

public class ShowUserServlet extends HttpServlet {

	/**
	 * 展现当前所有登录用户
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc = request.getSession().getServletContext();
		Map<String,HttpSession> map = 
			(Map<String, HttpSession>) sc.getAttribute("online");
		// 声明List
		List<Map<String,Object>> list = 
			new ArrayList<Map<String,Object>>();
		if(map != null) {
			// 转到list<Map<String,Object>>
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			//map.entrySet()要先把map转换成set类型
			for(Entry<String, HttpSession> m : map.entrySet()) {
				Map<String,Object> o = new HashMap<String,Object>();
				o.put("id", m.getKey());
				o.put("user", (User)m.getValue().getAttribute("user"));
				o.put("cTime", sdf.format(m.getValue().getCreationTime()) );
				o.put("lTime", sdf.format(new Date(m.getValue().getLastAccessedTime())));
				o.put("ip", m.getValue().getAttribute("ip"));
				list.add(o);
			}
			
			request.setAttribute("list", list);
		}
		//跳转
		request.getRequestDispatcher("/admin/user/list.jsp").forward(request, response);
	}

}
