package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueChars {
	
	
	public static Set<Character> uniquesCharsInString(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
		// System.out.println(map);
		for (char e : map.keySet()) {
			if (map.get(e) == 1) {
				set.add(e);
			}
		}
		return set;
	}
	
	/*
	 * public static HashSet<Character> removeDuplicates(String s) {
	 * HashSet<Character> set = new HashSet<Character>(); for(int i =
	 * 0;i<s.length();i++) { if(!set.contains(s.charAt(i))) { set.add(s.charAt(i));
	 * } } return set; }
	 */
	public static void main(String[] args) {
		System.out.println(uniquesCharsInString("rreeddyy"));
		// System.out.println((removeDuplicates("reddy")));
	}

}
