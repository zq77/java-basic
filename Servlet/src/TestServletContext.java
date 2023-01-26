import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
/**
 * Application����
 * ���ڱ�������webӦ�õ����������ڶ����Է��ʵ�����
 * �ɹ������ͬ���ڷ��ʣ�����Ϊĳһҳ�汻�ܹ����ʴ����ļ�������������վ��ҳ�ķ�������
 */
public class TestServletContext extends HttpServlet { 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        
        // Returns a reference to the ServletContext in which this servlet is running. 
        ServletContext application = this.getServletContext();
        // �ӵ�ǰapplication�ж�ȡ����accessCount��ֵ
        Integer accessCount = (Integer)application.getAttribute("accessCount");
        if(accessCount == null) {
            accessCount = new Integer(0);
        } else {
            accessCount = new Integer(accessCount.intValue() + 1);
        }
        // ��ǰapplication�в������key�����ԣ�ֵ��value����
        application.setAttribute("accessCount", accessCount);
        
        out.println("<html><head><title>ServletContext����</title></head><br>"
                + "<body><td>" + accessCount +"</td>\n"
                + "</body></html>");
        
    } 
} 