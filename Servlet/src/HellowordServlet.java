import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HellowordServlet extends HttpServlet {

	/*
	 *��javaд��class�ļ����� webapps\WebContent\WEB-INF\classes Ŀ¼��	Ȼ�����ֱ��ͨ��IE���ʣ���������Ϊһ��������
	 *ע��Ҫ����web.xml������
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DOGET is connect");
		resp.getWriter().println("<a href='http://www.baidu.com/'>println</a>");
		resp.getWriter().write("<a href='http://www.baidu.com/'>write</a>");	//����Ҫ�õ�����
		
		//write��print	���Ƿ�����ʹ��servlet��java���ļ�ת����html���ݸ��ͻ��ˣ�ʹ�ͻ��˵��������ȡhtml����ʾ��ҳ
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
