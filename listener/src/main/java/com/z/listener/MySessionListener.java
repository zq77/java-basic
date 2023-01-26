package com.z.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用来记录session的创建和销毁，来统计在线人数
 * listener是单例模式
 * @author z
 *
 */
public class MySessionListener implements HttpSessionListener {

	private int current = 0;//当前的在线人数
	
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();// 得到当前用户的session
		System.out.println("session以创建 ： " + Thread.currentThread().getName() + " : " +session.getId());
		
		ServletContext sc = session.getServletContext();
		sc.setAttribute("current", ++current); //每当服务器创建一个session的时候就将session的个数放到ServletContext中
		
		List<HttpSession> list = (List<HttpSession>) sc.getAttribute("list"); //获取ip的时候用的
		
		if(list == null) {	//第一次登陆的时候
			list = new ArrayList<HttpSession>();
		}
		list.add(session);
		sc.setAttribute("list", list);
		
	}

	/**
	 * session销毁的话就要将销毁的session移除
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();// 得到当前用户的session
		System.out.println("session以销毁 ： " + Thread.currentThread().getName() + " : " +session.getId());
		ServletContext sc = session.getServletContext();
		sc.setAttribute("current", --current);//每当服务器销毁一个session的时候就将session的个数放到ServletContext中
		
		List<HttpSession> list = (List<HttpSession>) sc.getAttribute("list"); //获取ip的时候用的
		list.remove(session);
		sc.setAttribute("list", list);
		Map<String,HttpSession> map = 
			(Map<String, HttpSession>) sc.getAttribute("online");
		map.remove(session.getId());
		sc.setAttribute("map", map);
	}

}
