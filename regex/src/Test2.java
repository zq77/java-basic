import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test2 {

	/**����Matcher.matches()����ȫ��ƥ��ʱ����������ƥ����ַ������������ƥ�仹��������ƥ��	
	 * ���ַ��ϣ���ʱ�����ҪMatcher.reset() ����ƥ��������ƥ��ص���ͷ
	 */
	public static void main(String[] args) {
		/*Pattern p = Pattern.compile("\\d{2,7}");
		Matcher m = p.matcher("123-4234-45346");	//һ����ܾ��൱��һ���ֶ�
		
		z(m.matches());
		m.reset();			//����仰��һ�������û����仰��һ�����
		
		z(m.find());
		z(m.start()+ "-" + m.end());
		z(m.find());
		z(m.start()+ "-" + m.end());
		z(m.find());
		z(m.start()+ "-" + m.end());

		z(m.lookingAt());*/
		
//group ��������	()���Բ鿴�м��Է���
		Pattern p = Pattern.compile("(\\d{2,7})(\\w*)");
		Matcher m = p.matcher("12312sdfs-23123fsdf-12d");
		while (m.find()) {
			z(m.group());		//�鿴�����ִ�
			z(m.group(1));		//�鿴ֻ�����ֵ��Ӵ�
			z(m.group(2));		//�鿴ֻ����ĸ���Ӵ�
		}
		
	}
	
	private static void z(Object o) {
		System.out.println(o);
	}

}
