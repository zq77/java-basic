import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test3Reflect {

	/**
	 * Class.forname("...")  ���Խ�һ����load���ڴ�
	 * 		��һ����ʵ����Ҳ���Խ�һ����	load���ڴ濪ʼִ��
	 * Class.newInstance() ������ Class ��������ʾ�����һ����ʵ����
	 * Class.getMethods()	���Բ鿴���еķ���
	 * Method.getReturnType()	���Բ鿴�˶�������ʾ�ķ����ķ�������
	 */
	public static void main(String[] args) {
		String str = "Z";

		try {
//����һ����	�õ��ǵ�3���������
			Class c = Class.forName(str);
			
//û����仰���޷�ִ��Z���췽���е����	������һ���µ�ʵ��	��ͬZ z = new Z();
			Object o = c.newInstance();

			Method[] m = c.getMethods();
			for(int i = 0; i < m.length; i++) {
				if(m[i].getName().equals("q")) {
//ע�����������õ��Ƕ���������o	��������class c
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
		System.out.println("��̬����");
	}
	
	public Z() {
		System.out.println("��̬���õ���");
	}
	
	public String sd() {
		return "����ֵ��String����";
	}
	
	public void q() {
		System.out.println("q������");
	}
}