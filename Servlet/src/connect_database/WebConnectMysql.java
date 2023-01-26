package connect_database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebConnectMysql extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=gb2312");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println("<table align='center'><tr><td>" + "²éÑ¯Êý¾Ý¿â" + "</td></tr>");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/z?user=root&password=root");
            stmt = conn.createStatement();
            String sql = "select * from dept";
            rs = stmt.executeQuery(sql); 
            while(rs.next()) {
            	pw.println("<tr><td>" + rs.getString("loc") + "</td></tr>");
            }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			try {
				if (rs != null) rs.close();
				if (stmt != null) rs.close();
				if (conn != null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        pw.println("</table></body></html>");
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
