import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HellowordServlet extends HttpServlet {

	/*
	 *将java写的class文件放在 webapps\WebContent\WEB-INF\classes 目录下	然后就能直接通过IE访问，将本机作为一个服务器
	 *注意要更改web.xml的配置
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DOGET is connect");
		resp.getWriter().println("<a href='http://www.baidu.com/'>println</a>");
		resp.getWriter().write("<a href='http://www.baidu.com/'>write</a>");	//引号要用单引号
		
		//write和print	都是服务器使用servlet将java的文件转换成html传递给客户端，使客户端的浏览器读取html，显示网页
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
