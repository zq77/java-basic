
public class Test {

	/**
	 * 动态语句块new一个对象的时候会被执行一次，静态语句块只执行一次
	 */
	public static void main(String[] args) {
		new A();
		new A();
		
		new B();
		new B();

	}

}
//静态语句块
class A {
	static {
		System.out.println("静态语句块");
	}
}
//动态语句块
class B{
	{
		System.out.println("动态语句块");
	}
	
}
