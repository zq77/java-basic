
public class Test {

	/**
	 * ��̬����newһ�������ʱ��ᱻִ��һ�Σ���̬����ִֻ��һ��
	 */
	public static void main(String[] args) {
		new A();
		new A();
		
		new B();
		new B();

	}

}
//��̬����
class A {
	static {
		System.out.println("��̬����");
	}
}
//��̬����
class B{
	{
		System.out.println("��̬����");
	}
	
}
