package com.z.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�ض���  -- ������֪ͨ����������·�������
		//������ȷ�����·��͵�URL������ʹ�þ���(����) http://localhost:8080/  -- http://www.baidu.com
		// * 1.html  --> http://localhost:8080/day07/1.html
		String url = "http://localhost:8080/session&cookie/index.jsp";
		/* ȷ������ǰҳ����Ŀ��ҳ��ʱ��������
		 * ��ǰҳ�棺http://localhost:8080/day07/sendServlet
		 * Ŀ��ҳ�棺http://localhost:8080/day07/1.html
		 */
//		String url = "1.html";
//		String url = "/day07/1.html";
//		String url = "./1.html";
//		String url = "../day07/1.html";
		resp.sendRedirect(url);
		//��ȫ�ȼۣ�������HTTPЭ��ľ���Ҫ��
		//��ת
		//resp.setStatus(302);
		//resp.setHeader("location", "http://localhost:8080/day07/1.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
