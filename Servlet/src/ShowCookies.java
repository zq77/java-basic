import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCookies extends HttpServlet {
	
	/*	
	 * 这个是服务器从客户端读取cookie文件
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html;charset=gb2312");
		pw.println("<html><head><title>读取所有参数</title></head>" +
				"<body>\n" + "<h1 align=center>"+"读取所有cookie"+"<h1>\n"
				+"<table width=768 align=center border=2>");
		Cookie[] cook = req.getCookies();
		if(cook != null) {
			for(int i=0;i<cook.length;i++) {
				pw.println("<tr><td>"+ cook[i].getName() + "</td>");
				pw.println("<td>" + cook[i].getValue() + "</td></tr>");
			}
		}
		pw.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
