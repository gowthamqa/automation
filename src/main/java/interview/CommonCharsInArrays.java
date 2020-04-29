package interview;

import java.util.Set;
import java.util.TreeSet;

public class CommonCharsInArrays {
	
	public static void main(String[] args) {
		String s1 = "ApplE";
		String s2 = "ApPle";
		//char[] ar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] ar = {'O','P','Q','R','S','k','l','m','n','T','U','V','W','A','B','C','D','E','F','G','H','I','J','K','L','M','N','X','Y','Z','a','b','c','d','e','f','g','h','j','o','p','q','r','s','t','u','v','w','x','y','z'};
		System.out.println(ar.clone().length);
		//Arrays.sort(ar);
		Set<Character> c = new TreeSet<Character>();
		for(char a: ar) {
			if(s1.indexOf(a) != -1 && s2.indexOf(a) != -1) {
				System.out.println(a);
				c.add(a);
			}
		}
		System.out.println("===============");
		System.out.println(c);
	}
	
}
