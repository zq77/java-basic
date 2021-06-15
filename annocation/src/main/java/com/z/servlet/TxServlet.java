package com.z.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.z.model.User;
import com.z.service.TxService;
import com.z.service.TxServiceImpl;
import com.z.utils.TxProxy;

/**
 * 使用代理来控制事务
 */
public class TxServlet extends HttpServlet {
	/**
	 * 注入service的实例,必须要使用接口，因为动态代理的时候接受的是接口target.getClass().getInterfaces(),所以看似TxServiceImpl类是被代理对象，其实他的接口才是被代理对象
	 */
	private TxService txservice = (TxService) TxProxy.createProxy(new TxServiceImpl());


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		u.setName("qid");
		u.setPassword("sdw22");
	
		txservice.save(u);
		System.out.println(">>>>>>>>>list");
		txservice.showAll();
	}

}
