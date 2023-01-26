package connect_database;

import java.sql.*;
/*
 * 专门用来和数据库连接的类 
 */
public class Db {
	
	//用来连接数据库
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/z?user=root&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	  // 获取表达式语句
    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("执行获取表达式语句过程中出现了错误。。。");
            e.printStackTrace();
        }        
        return stmt;
    }
    
    // 获取查询的结果集
    public static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println("执行查询过程中出现了错误。。。");
            e.printStackTrace();
        }
        return rs;
    }

    // 关闭结果集
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            System.out.println("执行关闭结果集过程中出现了错误。。。");
            e.printStackTrace();
        }        
    }
    
    // 关闭表达式语句
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            System.out.println("执行关闭表达式语句过程中出现了错误。。。");
            e.printStackTrace();
        }        
    }
      
	   // 关闭连接
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("执行关闭数据库连接过程中出现了错误。。。");
            e.printStackTrace();
        }        
    }

}
