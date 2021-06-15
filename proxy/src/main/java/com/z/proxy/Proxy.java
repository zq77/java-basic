package com.z.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;

//?????????????????
public class Proxy {
	
	public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {//JDK6 Complier API, CGLib, ASM
		String methodStr = "";
		String rt = "\r\n";
		Method[] methods = infce.getMethods();
		
		for(Method m : methods) {
			methodStr += "	@Override" + rt + 
			 			 "	public void " + m.getName() + "() {" + rt +
						 "    try {" + rt +
						 "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() +			
						 "\");" + rt +
						 "    h.invoke(this, md);" + rt +
						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
						
						 "}" + rt;
		
		}
//???????e:/src/com/z/proxy/??	
		String src = 
			"package main.java.proxy;" +  rt +
			"import java.lang.reflect.Method;" + rt +
			"import main.java.proxy.*;" + rt +
			"public class $Proxy1 implements " + infce.getName() + "{" + rt +
			"    public $Proxy1(InvocationHandler h) {" + rt +
			"        this.h = h;" + rt +
			"    }" + rt +

			"    main.java.proxy.InvocationHandler h;" + rt +
							
			"    " + methodStr + rt +
			"}";
		String path = Proxy.class.getResource("").getPath();
		System.out.println(path);
		String fileName = path + "$Proxy1.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile ????
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load into memory and create an instance
		URL[] urls = new URL[] {new URL("file:/" + "e:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("main.java.proxy.$Proxy1");
		System.out.println(c);
//$Proxy1???????????????		ctr.newInstance(h);  h?????TimeHandler 	ctr??$Proxy1???????
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		Object m = ctr.newInstance(h);
		System.out.println(m.getClass());		
		return m; 
	}
}
