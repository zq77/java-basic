import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
public class Test {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<String> list = new ArrayList<String>();
//		List l = list;
//		l.add(11);
		Method m = List.class.getMethod("add", Object.class);
		m.invoke(list, 11);
		for(Object s : list){
			System.out.println(s + ":" + s.getClass());
		}
	}
}
