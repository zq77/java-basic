import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test3 {

	/**
	 *	灵活运用替换字符串	在第几个位置是大写还是小写
	 */
	public static void main(String[] args) {
		Pattern p = Pattern.compile("lucky", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("aLUCKydf fluCkyju dnfuLuCkywnfu lucky sdfasdf");
		int i = 0;
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			i ++;
			if (i == 2) {
				m.appendReplacement(sb, "LUCKY");
			} else {
				m.appendReplacement(sb, "lucky");
			}
		}
		//z(m.start() + "-" + m.end());
		m.appendTail(sb);				//没有这句话的话最后的 sdfasdf就显示不了
		z(sb);
	}
	
	private static void z(Object c) {
		System.out.println(c);
	}

}
