package annocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.z.utils.ProxyDemo;

public class TestProxyDemo {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		List o = (List)ProxyDemo.createProxy(list);	//要将被代理的对象传进去
		o.add("ds");
		System.out.println(o.get(0) + " : " + o.getClass());
	}
}
