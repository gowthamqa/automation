package interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SolutionLocal {

	private static final Scanner scanner = new Scanner(System.in);

	public static boolean isValidParenthesis(String s) {
		// boolean isValidPareenthesis = true;
		char temp = ' ';
		Stack<Character> st = new Stack<Character>();
		if(s.length()%2!=0) {
			return false;
		}
		if(s.isEmpty()) {
			return true;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '}') {
				temp = '{';
			} else if (s.charAt(i) == ')') {
				temp = '(';
			} else if (s.charAt(i) == ']') {
				temp = '[';
			}
			if (st.isEmpty()) {
				st.push(s.charAt(i));
			} else {
				if (st.peek() != temp) {
					st.push(s.charAt(i));
				} else {
					st.pop();
				}
			}

		}
		if (st.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public static void charCount(String s) {
		s = s.toLowerCase();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
		System.out.println(map);
	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		//Implementaion 1
		/*TreeSet<String> sets = new TreeSet<String>();
		for (int i = 0; i <= s.length() - k; i++) {
			sets.add(s.substring(i, i + k));
			System.out.println(s.substring(i, i + k));
		}
		smallest = sets.first();
		largest = sets.last();
		return smallest + "\n" + largest;*/
		
		//implementation 2
		/*String[] result = new String[s.length()-k+1];
		for(int i = 0;i<=s.length()-k;i++) {
			result[i] = s.substring(i, i+k);
		}
		for(int i = 0;i < result.length;i++) {
			for(int j = i+1;j<result.length;j++) {
				if(result[j].compareTo(result[i])<0) {
					String temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		return result[0] + "\n" + result[result.length-1];*/

		//implementation 3
		/*String[] result = new String[s.length() - k + 1];
		for (int i = 0; i <= s.length() - k; i++) {
			result[i] = s.substring(i, i + k);
		}
		smallest = result[0];
		largest = result[0];
		for(int i = 0;i < result.length;i++) {
			if(result[i].compareTo(smallest)<0) {
				smallest = result[i];
			}else if(result[i].compareTo(largest)>0) {
				largest = result[i];
			}
		}
		return smallest + "\n" + largest;*/
		//implementation 3
		/*String[] result = new String[s.length() - k + 1];
		for (int i = 0; i <= s.length() - k; i++) {
			result[i] = s.substring(i, i + k);
		}
		smallest = result[0];
		largest = result[0];
		for (int i = 0; i < result.length; i++) {
			if (result[i].compareTo(smallest) < 0) {
				smallest = result[i];
			} else if (result[i].compareTo(largest) > 0) {
				largest = result[i];
			}
		}
		return smallest + "\n" + largest;*/
		
		//implementation 4
		smallest = s.substring(0, k);
		largest = s.substring(0, k);
		for (int i = 0; i <= s.length() - k; i++) {
			if (s.substring(i, i + k).compareTo(smallest) < 0) {
				smallest = s.substring(i, i + k);
			} else if (s.substring(i, i + k).compareTo(largest) > 0) {
				largest = s.substring(i, i + k);
			}
		}
		return smallest + "\n" + largest;											
	}

	public static boolean isSherlockString(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0;i<s.length();i++) {
			if(!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			}else {
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			}	
		}
		System.out.println(map);
		int minimum = (int) Math.pow(10, 5);
		int maximum = 0;
		for(int v : map.values()) {
			if(minimum > v) {
				minimum = v;
			}else if(maximum < v) {
				maximum = v;
			}
		}
		if(minimum == maximum) {
			return true;
		}
		if(maximum - minimum > 1) {
			return false;
		}
		int countBiggerThanMin = 0;
	    for(int value : map.values()) {
	        if(value > minimum ) {
	            countBiggerThanMin++;
	        }
	    }
	    System.out.println(countBiggerThanMin);
	    System.out.println(map.size());
	    if((countBiggerThanMin == 1) || (countBiggerThanMin == (map.size() - 1))) { 
	        return true;
	    }
	    return false;
		
		/*int[] values = new int[map.size()];
		int k = 0;
		for(Character c : set) {
			values[k] = map.get(c);
			k++;
		}
		//Integer[] values = (Integer[]) map.values().toArray();
		int count = 0;
		for(int i = 0;i<values.length-1;i++) {
			for(int j = i+1;j<values.length-1;j++) {
				if(values[i] != values[j]) {
					if(Math.abs(values[i] - values[j]) == 1) {
						count++;
						if(count > 1) {
							return false;
						}
						
					}
				}
				
			}
			
		}*/		

	}
	static boolean isAnagram(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		if (a.length() != b.length()) {
			return false;
		} else {
			for (int i = 0; i < a.length(); i++) {
				if (b.indexOf(a.charAt(i)) == -1) {
					return false;
				} else {
					b = b.substring(0, b.indexOf(a.charAt(i))) + b.substring(b.indexOf(a.charAt(i)) + 1);
				}
			}
		}
		return true;
	}

	static int noOfWays(int n) {
		if (n < 1)
			return 0;
		if (n == 1) {
			return 1;

		} else if (n == 2) {
			return 2;
		}
		return noOfWays(n - 1) + noOfWays(n - 2);
	}

	LinkedList<Character> queue = new LinkedList<Character>();

	int size() {
		return queue.size();
	}

	boolean isEmpty() {
		return queue.isEmpty();
	}

	void enQueue(char a) {
		queue.addLast(a);
	}

	char deQueue() {
		return queue.remove(0);
	}

	char peek() {
		return queue.get(0);
	}

	public static void main(String[] args) {

		SolutionLocal sol = new SolutionLocal();
		//String fail = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
		//String fail1 = "ebhcgicceggecgdcibbeicigehhebabiehbdgaeaigihghbhigihfebgabicbgfhhedgbfehiahchcecedffhccebifcbdfcfaecicafahfiecceeaabbecfhgbfifabbffadcieeaiidddhfdeccaedbgcfdehbadihheieidgcfbdiiicgahebfbbdfeffegbdhgdagefhbgafaabfghdcbfdhabhfahbdhgifbghhafcieachcbeabccbiigdcfegcccfafehegbiecbdhabcffggiifaabfagbfdfbfacdcafabccgibiidgabiabigbgbbaideeagaaffcddhieicehhchfedfgbgbfhgedhacegaieeedggacbbgadeibbbcdhbabbieibcfbhgdbbiecdhbffaghhchhddcihgdgbgdcfgfggeaahffgiddeadgcegaiddhhdgagdidgacafececiebeigcbdfaedibbgbhciihcdifbacdagfbcefifefchhddadeaiegbfaidbeebiefghfghhdabdeegabagfbbdgbeaiiigeaadhbgebedddfihagdeiccdbcfchgadhgfaidaebfabbagdghebgagbfhfbgeagdgecbhfchebdgafceaffabagedbhcgcedaecdbiifefchcbgfbbibhiahchhfadffeacfbgeigaccedadaafhcieficdfhfheibfdhbgbfhhdfcghabacggchchbdaigbcihhdbifcdeggicgacehebadbdaibhdciefdgfhfeggdhgcaeeeidfebbaicgagcaiachffhadbddhhdbcehciagfdgeadidfcaaiafeadefbbbaidgiagbeacchbdaifgccgcfigefcachiiggbghfhbifciafgfigaabidhdgffcbgicbidibacbgfhddafbegdaagbhddceeifecciddigfiehdbdabahgaechffidebhicfcciahhchebdbei";
		//System.out.println(fail+"s >>>\n"+isSherlockString(fail));
		//System.out.println(fail1+"s >>>\n"+isSherlockString(fail1));
		//System.out.println("aauhghgfbbccddeefghi >>>"+isSherlockString("aauhghgfbbccddeefghi"));
		//System.out.println("abc >>> "+isSherlockString("abc"));
		//System.out.println("abcdefghhgfedecba >>> "+isSherlockString("abcdefghhgfedecba"));
		//System.out.println("aabbccddeefghi >>> "+isSherlockString("aabbccddeefghi"));
		
		

		//System.out.println(isValidParenthesis("{}"));
		//System.out.println(isValidParenthesis("()"));
		//System.out.println(isValidParenthesis("[]"));
		//System.out.println(isValidParenthesis(")("));
		//System.out.println(isValidParenthesis("(){}[()]"));
		System.out.println(isValidParenthesis("{[()]}(}"));

		// System.out.println(noOfWays(2));
		// System.out.println(noOfWays(100));
		// System.out.println(noOfWays(23));
		// System.out.println(noOfWays(23));
		// String s = "string";
		// System.out.println(s.length()+" "+s.substring(3,6));
		// String result[] = s.split(",");
		// System.out.println(getSmallestAndLargest("welcometojava",3));
		// System.out.println(getSmallestAndLargest("welcometojava",2));
		// System.out.println(result[0]+"\n"+result[1]);
		// System.out.println(isAnagram("cat", "act"));
		// System.out.println(isAnagram("cat", "agct"));
		// System.out.println(isAnagram("catc", "atct"));
		// System.out.println(isAnagram("anagram", "margana"));
		// System.out.println(isAnagram("anagramm", "marganaa"));
		// charCount("EnglandWonTheworldcup");
	}
}
