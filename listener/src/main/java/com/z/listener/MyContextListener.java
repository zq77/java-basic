package com.z.listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 用来管理ServletContext的创建和销毁的
 * @author z
 *
 */
public class MyContextListener implements ServletContextListener {
	//在销毁这个对象时保存一些数据到数据库或是文件中
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁了:"+arg0.getServletContext());
		//保存到文件中去
		URL url = MyContextListener.class.getClassLoader().getResource("number.txt");
		String path = url.getFile();
		System.out.println(path);
		
		File file = new File(path);
		try {
			PrintWriter out = new PrintWriter(file);
			//获取applicat的数据
			int number = (Integer) arg0.getServletContext().getAttribute("number");
			
			out.print(number);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 初始化的时候可以用来读取配置文件
	 * 还读取数据库之前保存的数据，可以统计网站的访问量
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("application被创建了:"+arg0.getServletContext());
		URL url = this.getClass().getClassLoader().getResource("number.txt");
		String path = url.getFile();
		System.out.println(path);
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(path));
			String line = bf.readLine();
			int number = 0;
			if(line != null) {
				number = Integer.parseInt(line);
			}
			arg0.getServletContext().setAttribute("number",number);
			System.out.println("初始的值是:"+number);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
