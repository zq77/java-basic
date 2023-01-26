package application;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestApplication extends HttpServlet {
	/**
	 * Application测试
	 * 用于保存整个web应用的生命周期内都可以访问的数据
	 * 可供多个不同窗口访问，可作为某一页面被总共访问次数的计数器（比如网站首页的访问量）
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gb2312");
//这句话就是在服务器上开辟一块内存，用作Application
		ServletContext application = this.getServletContext();
		Integer accessCount = (Integer)application.getAttribute("accessCount");
		if(accessCount == null) {
			accessCount = new Integer(0);
		} else {
			accessCount = new Integer(accessCount.intValue() + 1);
		}
		application.setAttribute("accessCount", accessCount);
		resp.getWriter().println("<html><head><title>ServletContext测试</title></head><br>"
                + "<body><td>" + accessCount +"</td>\n"
                + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
