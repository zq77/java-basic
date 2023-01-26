package connect_database;

import java.sql.*;
/*
 * ר�����������ݿ����ӵ��� 
 */
public class Db {
	
	//�����������ݿ�
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
	
	  // ��ȡ���ʽ���
    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("ִ�л�ȡ���ʽ�������г����˴��󡣡���");
            e.printStackTrace();
        }        
        return stmt;
    }
    
    // ��ȡ��ѯ�Ľ����
    public static ResultSet getResultSet(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            System.out.println("ִ�в�ѯ�����г����˴��󡣡���");
            e.printStackTrace();
        }
        return rs;
    }

    // �رս����
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            System.out.println("ִ�йرս���������г����˴��󡣡���");
            e.printStackTrace();
        }        
    }
    
    // �رձ��ʽ���
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            System.out.println("ִ�йرձ��ʽ�������г����˴��󡣡���");
            e.printStackTrace();
        }        
    }
      
	   // �ر�����
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("ִ�йر����ݿ����ӹ����г����˴��󡣡���");
            e.printStackTrace();
        }        
    }

}
