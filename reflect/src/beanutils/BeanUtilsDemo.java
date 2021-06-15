package beanutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.z.model.User;

public class BeanUtilsDemo {
	/**
	 * Beanutils只可以默认转换了最基本的类型
	 * 如果希望设置其他类型，可以自己转换
	 * 或是注册转换器
	 * 如果设置的没有某个属性，则会忽略
	 * 必须通过set和get
	 * @throws Exception
	 */
	@Test
	public void setValue() throws Exception{
		User u = new User();
		String dd = "2009-09-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date ddd = sdf.parse(dd);
		
		BeanUtils.setProperty(u, "name", "Jack");
		BeanUtils.setProperty(u, "age", "90");
		BeanUtils.setProperty(u,"birth",ddd);
		BeanUtils.setProperty(u, "time", sdf.format(new Date()));
		System.err.println(u);
	}
	
	@Test
	public void setValues() throws Exception{
		User u = new User();
//		BeanUtils.setProperty(u, "name", new String[]{"Rose","Jack"});
//		System.err.println(u);
		
		Map<String,Object> o = new HashMap<String, Object>();
		o.put("name", "KDKDKD");
		o.put("age", "8888");
		
		BeanUtils.populate(u,o);
		System.err.println(u);
	}
}
