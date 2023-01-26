package com.z.filter;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 对jsp文件实现压缩
 * @author z
 *
 */
public class GZipFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		MyResponse resp = new MyResponse((HttpServletResponse) response);
		chain.doFilter(request, resp);
		
		//从包装好的response中得到字节
		byte[] src = resp.getSrc();
		//声明缓存容器
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		//声明压缩流
		GZIPOutputStream zip = new GZIPOutputStream(stream);
		//压缩数据
		zip.write(src);
		//关闭压缩工具流
		zip.close();
System.out.println("压缩之前字节码大小："+src.length);	
		//获取压缩以后数据
		byte[] dest = stream.toByteArray();
System.out.println("压缩以后的字节码大小："+dest.length);
		//输出
		//必须要使用原生 的response
		HttpServletResponse res = (HttpServletResponse) response;
		//必须要输出压缩以后字节数组
		res.setContentType("text/html;charset=UTF-8");
		//必须要使用字节流来输出信息
		OutputStream out = resp.getOutputStream();
		//10:通知浏览器。这是压缩的数据，要求浏览器解压
		res.setHeader("Content-encoding","gzip");//必须
		res.setContentLength(dest.length);
		out.write(dest);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}

class MyResponse extends HttpServletResponseWrapper {
	//缓存区
	private ByteArrayOutputStream stream;
	private PrintWriter out;
	
	public MyResponse(HttpServletResponse response) {
		super(response);
	}

	//重写writer
	@Override
	public PrintWriter getWriter() throws IOException {
		stream = new ByteArrayOutputStream();
//		System.out.println("有人想获取输出流");
		out = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
		return out;
	}
	
	//得到缓存区的数据
	public byte[] getSrc() {
		if(out != null) {
			//输出流不为空的话就把他关掉，否则会不显示压缩的数据
			out.close();
		}
		return stream.toByteArray();
	}
}