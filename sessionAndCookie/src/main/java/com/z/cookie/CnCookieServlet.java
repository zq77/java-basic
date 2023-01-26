package com.z.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CnCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//String[]  -- byte[]
		//"����".getBytes("UTF-8") -- byte[] -- > 12,45,67,98
		//12,45,67,98  --> String[] -- byte[]  -- new String()
		
		//��ȡcookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				System.out.println(c.getName() + ":" + c.getValue());
				//���cn��ֵ��Ȼ�����
				if("cn".equals(c.getName())){
					String value = URLDecoder.decode(c.getValue(), "UTF-8");
					System.out.println(value);
				}
			}
		}
		
		//����cookie,��cookie֮ǰ�Ƚ������ĵ�cookie����
		String data = "����";
		String returnData  = URLEncoder.encode(data, "UTF-8");  //base64
		
		Cookie cookie = new Cookie("cn",returnData);
		
		resp.addCookie(cookie);
System.out.println("cookie�Ѵ洢");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
