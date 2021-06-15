import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test2 {

	/**当用Matcher.matches()进行全局匹配时，遇到不能匹配的字符，程序结束但匹配还在他不能匹配	
	 * 的字符上，这时候就需要Matcher.reset() 重置匹配器，让匹配回到开头
	 */
	public static void main(String[] args) {
		/*Pattern p = Pattern.compile("\\d{2,7}");
		Matcher m = p.matcher("123-4234-45346");	//一个横杠就相当于一个分段
		
		z(m.matches());
		m.reset();			//有这句话是一个结果，没有这句话是一个结果
		
		z(m.find());
		z(m.start()+ "-" + m.end());
		z(m.find());
		z(m.start()+ "-" + m.end());
		z(m.find());
		z(m.start()+ "-" + m.end());

		z(m.lookingAt());*/
		
//group 分组运用	()可以查看有几对分组
		Pattern p = Pattern.compile("(\\d{2,7})(\\w*)");
		Matcher m = p.matcher("12312sdfs-23123fsdf-12d");
		while (m.find()) {
			z(m.group());		//查看所有字串
			z(m.group(1));		//查看只有数字的子串
			z(m.group(2));		//查看只有字母的子串
		}
		
	}
	
	private static void z(Object o) {
		System.out.println(o);
	}

}
