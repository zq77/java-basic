
public class Test2ClassLoader {

	/**
	 * java文件都是通过classloader	load进内存开始执行
	 * jdk里面的classloader非常多
	 * ClassLoader.getParent() 不是继承，是通过引用返回上一层的classloader 
	 *  ClassLoader在load class的时候首先找上一层loader是不是load过了，如果load了就不会再load了
	 */
	public static void main(String[] args) {
	/*	//System.out.println(String.class.getName());
		System.out.println(String.class.getClassLoader());
//这个拿的是class的名字
		System.out.println(Test.class.getName());	
//jdk里面的classloader非常多	这个拿的是加载的classloader的名字
		System.out.println(Test.class.getClassLoader().getClass().getName());*/
		
// ClassLoader在load class的时候首先找上一层loader是不是load过了，如果load了就不会再load了
		ClassLoader c = Test2ClassLoader.class.getClassLoader();
		while (c != null) {
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}

}
