
public class Test2ClassLoader {

	/**
	 * java�ļ�����ͨ��classloader	load���ڴ濪ʼִ��
	 * jdk�����classloader�ǳ���
	 * ClassLoader.getParent() ���Ǽ̳У���ͨ�����÷�����һ���classloader 
	 *  ClassLoader��load class��ʱ����������һ��loader�ǲ���load���ˣ����load�˾Ͳ�����load��
	 */
	public static void main(String[] args) {
	/*	//System.out.println(String.class.getName());
		System.out.println(String.class.getClassLoader());
//����õ���class������
		System.out.println(Test.class.getName());	
//jdk�����classloader�ǳ���	����õ��Ǽ��ص�classloader������
		System.out.println(Test.class.getClassLoader().getClass().getName());*/
		
// ClassLoader��load class��ʱ����������һ��loader�ǲ���load���ˣ����load�˾Ͳ�����load��
		ClassLoader c = Test2ClassLoader.class.getClassLoader();
		while (c != null) {
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}

}
