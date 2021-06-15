import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


public class Test4email {
	
	private static Connection conn = null;
	private static PreparedStatement prst = null;
	
	/**
	 * 抓取网页中的email		插入到oracle的class中
	 */
	public static void main(String[] args) {
		conn();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("E:/sd.htm");
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				z(line);
			};
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		close();
	}

	private static void z(String line) {

		Pattern p = Pattern.compile("(\\d{1,10}||\\w{1,18})@[\\w[.-]]+\\.com");
		Matcher m = p.matcher(line);
		
		while (m.find()) {
			try {
				prst.setString(1, m.group());
				System.out.println(m.group());
				prst.executeUpdate();
System.out.println("插入完毕");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static void conn () {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "z", "z123456");
			prst = conn.prepareStatement("insert into email values(?)");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static void close() {
		try {
			if (prst != null) prst.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
