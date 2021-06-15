import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test6 {

	/**
	 * Greedy 数量词	Reluctant 数量词	Possessive 数量词
	 */
	public static void main(String[] args) {
		//Pattern p = Pattern.compile("(.{3,10})[0-9]");	//Greedy 数量词
		//Pattern p = Pattern.compile("(.{3,10}?)[0-9]");	//Reluctant 数量词
		Pattern p = Pattern.compile("(.{3,10}+)[0-9]");	//Possessive 数量词
		Matcher m = p.matcher("asd77fads9");
		if (m.find()) {
			System.out.println(m.start() + "-" + m.end());
		} else {
			System.out.println("error");
		}

	}

}
