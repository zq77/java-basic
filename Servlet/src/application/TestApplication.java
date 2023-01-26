package application;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestApplication extends HttpServlet {
	/**
	 * Application����
	 * ���ڱ�������webӦ�õ����������ڶ����Է��ʵ�����
	 * �ɹ������ͬ���ڷ��ʣ�����Ϊĳһҳ�汻�ܹ����ʴ����ļ�������������վ��ҳ�ķ�������
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gb2312");
//��仰�����ڷ������Ͽ���һ���ڴ棬����Application
		ServletContext application = this.getServletContext();
		Integer accessCount = (Integer)application.getAttribute("accessCount");
		if(accessCount == null) {
			accessCount = new Integer(0);
		} else {
			accessCount = new Integer(accessCount.intValue() + 1);
		}
		application.setAttribute("accessCount", accessCount);
		resp.getWriter().println("<html><head><title>ServletContext����</title></head><br>"
                + "<body><td>" + accessCount +"</td>\n"
                + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
