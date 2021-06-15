import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Test5CodeCounter {
	private static int note = 0;	//  注释的行数
	private static int blank_line = 0;	//空行的行数
	private static int normal_line = 0; //正常的代码的行数

	/**
	 * 统计代码的行数
	 */
	public static void main(String[] args) {
		File file = new File("F:/JavaProject/Tank War/src/tankwar6");
		File[] f = file.listFiles();
		for (int i=0; i<f.length; i++) {
			if (f[i].getName().matches(".*\\.java$")) {
				z(f[i]);
			}
		}
		
		System.out.println("note :" + note);
		System.out.println("blank_line :" + blank_line);
		System.out.println("normal_line :" + normal_line);
	}
	
	private static void z(File f) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = null;
			boolean notes = false;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$")) {
					blank_line ++;
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					note ++;
					notes = true;
				} else if (notes) {
					note ++;
					if (line.endsWith("*/")) {
						note ++;
						notes = false;
					}
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					note ++;
				} else if (line.startsWith("//")) {
					note ++;
				} else {
					normal_line ++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
