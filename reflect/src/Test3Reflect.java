import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test3Reflect {

	/**
	 * Class.forname("...")  可以将一个类load进内存
	 * 		将一个类实例化也可以将一个类	load进内存开始执行
	 * Class.newInstance() 创建此 Class 对象所表示的类的一个新实例。
	 * Class.getMethods()	可以查看类中的方法
	 * Method.getReturnType()	可以查看此对象所表示的方法的返回类型
	 */
	public static void main(String[] args) {
		String str = "Z";

		try {
//导入一个类	用的是第3个类加载器
			Class c = Class.forName(str);
			
//没有这句话就无法执行Z构造方法中的语句	创建了一个新的实例	等同Z z = new Z();
			Object o = c.newInstance();

			Method[] m = c.getMethods();
			for(int i = 0; i < m.length; i++) {
				if(m[i].getName().equals("q")) {
//注意这个里面调用的是对象所以是o	而不是类class c
					m[i].invoke(o);
				} else if (m[i].getName().equals("sd")) {
					Class type = m[i].getReturnType();
					System.out.println(type.getName());
				}
				
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
	}

}

class Z {
	int i = 0;
	String str = null;
	 
	static {
		System.out.println("静态调用");
	}
	
	public Z() {
		System.out.println("动态调用调用");
	}
	
	public String sd() {
		return "返回值是String类型";
	}
	
	public void q() {
		System.out.println("q被调用");
	}
}