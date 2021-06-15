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

public class EncodeFilter implements Filter {

	private String encode;//编码的格式
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encode);
		response.setContentType("text/html;charset=" + encode);
		HttpServletRequest req = (HttpServletRequest) request;
		//如果是通过get方式传递的就将request包装一下
		if("GET".equals(req.getMethod())) {
			req = new MyRequest(req);
		}
		chain.doFilter(req, response);
	}

	public void init(FilterConfig config) throws ServletException {
		//初始化的时候得到配置中Encode的值
		encode = config.getInitParameter("Encode");
	}

}
//包装request对getParameter加强
class MyRequest extends HttpServletRequestWrapper {

	public MyRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		try {
			value = new String(value.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
