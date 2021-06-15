package com.z.Garbage_Collector;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestGarbage_Collector {

	public static void main(String[] args) {
		A a = new A();//这是强引用，垃圾回收器不能回收
		
		WeakReference<A> weak = new WeakReference<A>(new A());//这里将a弱引用了
		
		a.change("sd");
		
		System.gc();//调用垃圾回收器
		
		System.out.println("A : " + a);
		
		a.change("sd");
	}
	
	@Test
	public void test() {
		A a  = new A();
		String s = new String("asd");
		a.change(s);
		System.out.println(a);	//值不变
		
		s = new String("vwd");
		a.change(s);
		System.out.println(a);	//值不变
	}
}

class A {
	public String str;
	/**
	 * Called by the garbage collector on an object when garbage collection 
	 * determines that there are no more references to the object. 
	 * A subclass overrides the finalize method to dispose of system 
	 * resources or to perform other cleanup. 
	 * 这个方法就是垃圾回收期回收内存中这个类的时候执行的
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("garbage collector is action");
	}
	
	public void change(String s) {
		str = s;
		System.out.println("change : " + str);
	}

	@Override
	public String toString() {
		return "A [str=" + str + "]";
	}
}
