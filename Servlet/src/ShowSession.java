import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
/**
 * Session׷��
 * ��������֧��Cookie������Session��ʱ����SessionId������Cookie��
 * ��������Լ����ʹ��URL��д�ķ�ʽʵ��Session��response.encodeURL()
 * 
 *
 */ 
public class ShowSession extends HttpServlet { 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        String str = "Session Tracking Example";
        String heading;
        
        // ����Ự�Ѿ����ڣ��򷵻�һ��HttpSession�����򴴽�һ���µ�
        HttpSession session = request.getSession(true);
        // �ӵ�ǰsession�ж�ȡ����accessCount��ֵ
        Integer accessCount = (Integer)session.getAttribute("accessCount");
        if(accessCount == null) {
            accessCount = new Integer(0);
            heading = "Welcome newUser";
        } else {
            heading = "Welcome Back";
            accessCount = new Integer(accessCount.intValue() + 1);
        }
        // ��ǰsession�в������key�����ԣ�ֵ��value����
        // Binds an object to this session, using the name specified.
        session.setAttribute("accessCount", accessCount);
        
        out.println("<html><head><title>Session׷��</title></head>"
                + "<body>" + heading + "<br>"
                + "<h2>Information on Your Session</h2><br>"
                + "\n" + "<table border=1 align=center>\n"
                + "<TH>Info Type<TH>Value" + "<br>"
                + "<tr>\n" + "<td>ID</td>\n"
                + "<td>" + session.getId() +"</td></tr>\n"
                + "<tr>\n" + "<td>CreatTime</td>\n"
                + "<td>" + new Date(session.getCreationTime()) +"</td></tr>\n"
                + "<tr>\n" + "<td>LastAccessTime</td>\n"
                + "<td>" + new Date(session.getLastAccessedTime()) +"</td></tr>\n"
                + "<tr>\n" + "<td>Number of Access</td>\n"
                + "<td>" + accessCount +"</td></tr>\n"
                + "</body></html>");
    } 
} 