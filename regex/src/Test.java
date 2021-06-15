import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	/**
	 * 正则表达式的概念	第一个
	 */
	public static void main(String[] args) {
/*//每个点就相当于一个字符	String.matches(String2) 就是看String是否和String2匹配
		System.out.println("abc".matches("..."));
		System.out.println("abcd".matches("..."));
		
		System.out.println("192.168.2.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		System.out.println("192".matches("[0-2][0-9][0-9]"));
		System.out.println(" ".matches("a+"));
	
//这句话的意思是将字符串中的数字全部转换成 ---
		System.out.println("ad23232df".replaceAll("\\d", "-"));

//下面这三句话和上面的第一句效果相同		Pattern这句是创建一个匹配模式	第二句的abc是要匹配的字符序列
		Pattern p = Pattern.compile("...");
		Matcher m = p.matcher("abc");
		System.out.println(m.matches());
//想在正则表达式里匹配一个 \ 必须写4个 \\\\		
		System.out.println("\\".matches("\\\\"));*/
		System.out.println("z13903417792@1631s.c.om".matches("^.{0,20}@[\\w[.-]]+\\.com$"));
	}

}
