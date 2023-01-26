package connect_database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * javabean的使用
 * 就是调用其他的类（Db）
 */
public class WebConnectsql extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        resp.setContentType("text/html;charset=gb2312");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><table border=1>");
        out.println("<tr><td>Content:</td></tr>");

        Connection conn = Db.getConnect();
        String sql = "select * from dept";
        Statement sta = Db.getStatement(conn);
        ResultSet rs = Db.getResultSet(sta,sql);
        try {
			while(rs.next()) {
				out.println("<tr><td>" + rs.getString("loc") + "</td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Db.close(rs);
			Db.close(sta);
			Db.close(conn);
			
		}
        out.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
