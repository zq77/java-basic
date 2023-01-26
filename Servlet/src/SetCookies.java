import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookies extends HttpServlet {
	
	/*	
	 * 这个是服务器向客户端写入cookie文件
	 * 2种cookie，cookie1是能存一段时间的，cookie2是一旦浏览器关闭就不存在的
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
System.out.println("asdas");	
		for(int i=0; i<3; i++) {
			Cookie cookie1 = new Cookie("PauseTimeCookieName"+i,"PauseTimeCookieValue"+i );
			cookie1.setMaxAge(3600);
			resp.addCookie(cookie1);
			
			Cookie cookie2 = new Cookie("NotSaveCookieName"+i,"NotSaveCookieName"+i );
			resp.addCookie(cookie2);
		}
	
		resp.setContentType("text/html;charset=gb2312");
		PrintWriter pw = resp.getWriter();
		pw.println("<a href='ShowCookies'>ShowCookies</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

	
}
