package com.z.propertydescriptor;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

import com.z.model.User;

/**
 * 内省（Introspector）是Java语言对 Bean类属性、事件的一种缺省处理方法。
 * 例如类A中有属性name,那我们可以通过getName,setName来得到其值或者设置新的值。
 * 通过 getName/setName来访问name属性，这就是默认的规则。Java中提供了一套API用来访问某个属性的
 * getter/setter方法， 通过这些API可以使你不需要了解这个规则（但你最好还是要搞清楚），
 * 这些API存放于包java.beans中。
 * @author z
 * 使用PropertyDescriptor类读取setget方法，这就是内省，自身成员变量的修改，内省顾名思义就是对自身的反省
 */
public class PropertyDescriptorDemo {

	/**
	 * PropertyDescriptor类
	 * 第一个参数是你要用的setXxx或者getXxx中的Xxx
	 * 第二个参数就是你要调用的javabean的class
	 */
	@Test
	public void test1() throws Exception {
		Object u = new User();
		PropertyDescriptor pd = new PropertyDescriptor("name", u.getClass());
		pd.getWriteMethod().invoke(u, "Rose");
		System.out.println(u);
	}
	
	/**
	 * 使用反射
	 */
	@Test
	public void test2() throws Exception {
		Object u = new User();
		//要得到返回类型
		Method m = u.getClass().getMethod("getName");
		
		u.getClass().getMethod("setName",m.getReturnType()).invoke(u, "Rose");
		System.out.println(u);
	}
}
