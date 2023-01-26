package com.z.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 用来记录session中属性的变化,可以显示所有登录的人
 * 如果有人登录的话就将登录人的session放到ServletContext域中
 * 如果有人注销的话就将该人的session从ServletContext域中移除
 * @author z
 *
 */
public class SessionAttrListener implements HttpSessionAttributeListener {

	//监听添加属性
	public void attributeAdded(HttpSessionBindingEvent e) {
		String name = e.getName();
		if("user".equals(name)) {
			//将这个Session缓存到ServletContext<Map<Jid,Session>>
			ServletContext sx = e.getSession().getServletContext();
			//先读取在servletContext的已经存在的登录的人对象集合	和记录在线人数的方法一样
			Map<String,HttpSession> map = 
				(Map<String, HttpSession>) sx.getAttribute("online");
			//如果还没有登录
			if(map == null) {
				map = new HashMap<String,HttpSession>();
				sx.setAttribute("online", map);
			}
			//必须要将用户的sesion放到map
			map.put(e.getSession().getId(), e.getSession());
		}
	}

	//监听删除属性
	public void attributeRemoved(HttpSessionBindingEvent e) {
		String name = e.getName();
		if("user".equals(name)) {
			Map<String,HttpSession> map = 
				(Map<String, HttpSession>) e.getSession()
				.getServletContext().getAttribute("online");
			map.remove(e.getSession().getId());
		}
	}

	//监听修改属性
	public void attributeReplaced(HttpSessionBindingEvent e) {
	}

}
