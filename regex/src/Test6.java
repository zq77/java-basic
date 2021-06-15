import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test6 {

	/**
	 * Greedy ������	Reluctant ������	Possessive ������
	 */
	public static void main(String[] args) {
		//Pattern p = Pattern.compile("(.{3,10})[0-9]");	//Greedy ������
		//Pattern p = Pattern.compile("(.{3,10}?)[0-9]");	//Reluctant ������
		Pattern p = Pattern.compile("(.{3,10}+)[0-9]");	//Possessive ������
		Matcher m = p.matcher("asd77fads9");
		if (m.find()) {
			System.out.println(m.start() + "-" + m.end());
		} else {
			System.out.println("error");
		}

	}

}
