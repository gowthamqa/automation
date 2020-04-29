package interview;

public class RemoveSpecialChars {

	public static void main(String[] args) {
		String s = "7c6edf7c-d2e7-11e9-ace3-72f880d37f25";
		StringBuilder sb = new StringBuilder();
		char c = '-';
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				s = s.substring(0, s.indexOf(c)) + s.substring(s.indexOf(c) + 1);
			}
			if(s.charAt(i) != c) {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(s);
		System.out.println(sb.toString());
	}
}
