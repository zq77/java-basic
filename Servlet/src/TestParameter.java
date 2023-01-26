import java.io.*;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestParameter extends HttpServlet {

	/*
	 *  HttpServletResponse.setContentType("text/html");	����ָ������ַ�������
	 *	HttpServletRequest .getParameter(java.lang.String name);	�����õ�ѯ��name��value
	 *	��Enumerationʵ�ֱ���
	 *	���õ���F:\tomcat6.0.29\webapps\WebContent\	 user.html	�ļ�
	 *	ע��Ҫ��class�ļ��ŵ�F:\tomcat6.0.29\webapps\WebContent\WEB-INF\classes��
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gb2312");		//������趨���ͣ���ô����Ŀ����Ǵ��ı�
		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>��ȡ���в���</title></head>" +
				"<body>\n" + "<h1 align=center>"+"��ȡ���в���"+"<h1>\n"
				+ "<table width=768 align=center border=2>" + "<tr>\n"
				+ "<td>" + "Parameter name" + "</td>" + "<td>" + "Parameter value" + "</td></tr>");
		Enumeration paraname = req.getParameterNames();
		
		while(paraname.hasMoreElements()) {
			String s = (String)paraname.nextElement();
			pw.println("<tr><td>" + s + "</td>\n");
			String[] paravalue = req.getParameterValues(s);
			if (paravalue.length==1) {
				if(paravalue[0].length() == 0) {
					pw.println("<td>" + "null" + "</td></tr>");
				} else {
					pw.println("<td>" + paravalue[0] + "</td></tr>");
				}
			} else {
				pw.println("<td><ul>");
				for(int i=0; i<paravalue.length; i++) {
					pw.println("<li>" + paravalue[i] + "</li>");
				}
				pw.println("</ul></td></tr>");
			}
		}
		pw.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post");
		this.doGet(req, resp);
	}

}
