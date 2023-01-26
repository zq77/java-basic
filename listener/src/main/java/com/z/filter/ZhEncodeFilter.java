package com.z.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ZhEncodeFilter implements Filter {
	//定义一个encode用来接受编码的格式
	private String encode;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+ encode);
		if("GET".equals(req.getMethod())) {
			req = new MyRequest(req);
		}
		chain.doFilter(req, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		//初始化的时候就读取编码的格式
		encode = arg0.getInitParameter("Encode");
	}

}
/**
 * 将HttpServletRequest方法包装一下
 * 用来处理中文乱码
 * @author z
 *
 */
class MyRequest extends HttpServletRequestWrapper {

	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
//这必须判断一下是否为空，否则报错
		if(value == null) return null;
		try {
			value = new String(value.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return value;
	}
	
}
