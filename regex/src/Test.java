import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	/**
	 * ������ʽ�ĸ���	��һ��
	 */
	public static void main(String[] args) {
/*//ÿ������൱��һ���ַ�	String.matches(String2) ���ǿ�String�Ƿ��String2ƥ��
		System.out.println("abc".matches("..."));
		System.out.println("abcd".matches("..."));
		
		System.out.println("192.168.2.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		System.out.println("192".matches("[0-2][0-9][0-9]"));
		System.out.println(" ".matches("a+"));
	
//��仰����˼�ǽ��ַ����е�����ȫ��ת���� ---
		System.out.println("ad23232df".replaceAll("\\d", "-"));

//���������仰������ĵ�һ��Ч����ͬ		Pattern����Ǵ���һ��ƥ��ģʽ	�ڶ����abc��Ҫƥ����ַ�����
		Pattern p = Pattern.compile("...");
		Matcher m = p.matcher("abc");
		System.out.println(m.matches());
//����������ʽ��ƥ��һ�� \ ����д4�� \\\\		
		System.out.println("\\".matches("\\\\"));*/
		System.out.println("z13903417792@1631s.c.om".matches("^.{0,20}@[\\w[.-]]+\\.com$"));
	}

}
