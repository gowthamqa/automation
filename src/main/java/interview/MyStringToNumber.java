package interview;

public class MyStringToNumber {
	
	public static boolean isAnargram(String s1, String s2) {
		
		System.out.println(">>>Before rplace "+s1+"  "+s2);
		s1 = s1.replaceAll("\\s", "").toUpperCase();
		s2 = s2.replaceAll("\\s", "").toUpperCase();
		
		System.out.println(">>>After rplace "+s1+"  "+s2);
		
		if(s1.length()!=s2.length()) {
			return false;
		}
		else {
			char[] charInstr = s1.toCharArray();
			for(char c : charInstr) {
				int index = s2.indexOf(c);
				if(index != -1) {
					s2 = s2.substring(0, index)+s2.substring(index+1);
				}
				else {
					return false;
				}
			}
		}
		return true;
		
	}

	public static int formAnagram(String s) {
		int result = 0;
		s = s.replaceAll("\\s", "").toUpperCase();
		System.out.println("...>>>"+s);
		int strLength = s.length();
		System.out.println(strLength);
		if(strLength%2!=0) {
			return -1;
		}else {
			int halfLength = s.length()/2;
			String s1 = s.substring(0, halfLength);
			String s2 = s.substring(halfLength);
			char[] charIns1 = s1.toCharArray();
			for(char c : charIns1) {
				int index = s2.indexOf(c);
				if(index == -1) {
					result++;
				} else {
					s2 = s2.substring(0, index)+s2.substring(index+1);
				}
			}
			
		}		
		return result;
	}

	public static int makingAnagrams(String s1, String s2) {
        //int result = 0;
        s1 = s1.replaceAll("\\s", "").toUpperCase();
        s2 = s2.replaceAll("\\s", "").toUpperCase();
        //System.out.println("...>>>"+s);
        if(s1.length()<=s2.length()) {
            char[] charIns1 = s1.toCharArray();
            for(char c : charIns1) {
            	int index1 = s1.indexOf(c);
                int index = s2.indexOf(c);
                if(index != -1) {
                    s2 = s2.substring(0, index)+s2.substring(index+1);
                    s1 = s1.substring(0, index1)+s1.substring(index1+1);
                } 
            }
        }else {
            char[] charIns2 = s2.toCharArray();
            for(char c : charIns2) {
                int index = s1.indexOf(c);
                int index2 = s1.indexOf(c);
                if(index != -1) {
                    s2 = s2.substring(0, index2)+s2.substring(index2+1);
                    s1 = s1.substring(0, index)+s1.substring(index+1);
                } 
            }
        }        
        return s1.length()+s2.length();


    }
	
	public static int convert_String_To_Number(String numStr){
         
        char ch[] = numStr.toCharArray();
        int sum = 0;
        //get ascii value for zero
        int zeroAscii = (int)'0';
        System.out.println(zeroAscii);
        for(char c:ch){
            int tmpAscii = (int)c;
            sum = (sum*10)+(tmpAscii-zeroAscii);
        }
        return sum;
    }
     
	public static String superReducedString(String s) {
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                s = s.substring(0,i-1)+s.substring(i+1);
                i = 0;
            }
        }
        if (s.length() == 0) {
            return "Empty String";
        } else {
            return s;
        }
    }
	
	public static int reverse(int number) {
		int result = 0;
		while(number>0) {
			int rem =0;
			rem = number%10;
			result = result*10+rem;
			number = number/10;
		}
		return result;
	}
    
	public static boolean parenthsis(String s) {
		
		s = s.replaceAll("\\s", "").replaceAll("{}", "").replaceAll("()", "").replaceAll("[]", "");
		if(s.length() == 0 || s.equals(null)) {
			return true;
		}
		else {
			return false;
		}
		//return false;
		
	}
	
	public static int factorial(int n) {
        int result = 1;
        for(int i = n;i>=1;i--){
            result = result*i;
        }
        return result;
    }
	
	public static void main(String a[]){
    	String s = "acfgvh";
    	//System.out.println(s.substring(1));
       // System.out.println("\"3256\" == "+convert_String_To_Number("3256"));
        //System.out.println("\"76289\" == "+convert_String_To_Number("76289"));
        //System.out.println("\"90087\" == "+convert_String_To_Number("90087"));
        //System.out.println(makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj","djfladfhiawasdkjvalskufhafablsdkashlahdfa"));
        //System.out.println(makingAnagrams("tcca"));
        //System.out.println(parenthsis("{}[]()"));
        //System.out.println(parenthsis("{()}"));
        //System.out.println(parenthsis("{(()]}"));
        //System.out.println(parenthsis("(()())()"));
    	
    	//pattern(5);
    	System.out.println(factorial(5));
    	System.out.println(factorial(1));
    	
    }
	
	public static String lowerUpperAddUnderscore(String s) {
		//int length = s.length();
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<s.length();i++) {
			if(i == s.length()-1) {
				sb.append(s.charAt(i));
			}
			else if(s.charAt(i+1) >= 'A' && s.charAt(i+1) <= 'Z' && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
					sb.append(s.charAt(i));
					sb.append('_');
					//s = s.substring(0, i)+"_"+s.substring(i);
			}
			else
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
 	public static void pattern(int n) {
		
		for(int i = 0;i<=n;i++) {
    		for(int j = 0;j<i;j++) {
    			System.out.print("# ");
    		}
    		System.out.println();
    	}
		System.out.println("===================================");
		for(int i = 5;i>0;i--) {
    		for(int j = 0;j<i;j++) {
    			System.out.print("# ");
    		}
    		System.out.println();
    	}
		System.out.println("===================================");
		for(int i = 0;i<=n;i++) {
    		for(int j = n;j<i;j--) {
    			System.out.print(" ");
    			for(int k = 0;k<=i;k++) {
    				System.out.print("# ");
    			}
    		}
    		
    		System.out.println();
    	}
		
		
	}
    
    public static void isAnagram(String s1, String s2)
    {
        //Removing white spaces from s1 and s2 and changing case to lower
 
        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
 
        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
 
        //Initially setting status as true
 
        boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status = false;
        }
        else
        {
            //Converting copyOfs1 to char array
 
            char[] s1ToArray = copyOfs1.toCharArray();
 
            //Checking whether each character of s1ToArray is present in copyOfs2
 
            for (char c : s1ToArray)
            {
                int index = copyOfs2.indexOf(c);
 
                if(index != -1)
                {
                    //If character is present in copyOfs2, removing that char from copyOfs2
 
                    copyOfs2 = copyOfs2.substring(0, index)+copyOfs2.substring(index+1, copyOfs2.length());
                }
                else
                {
                    //If character is not present in copyOfs2, setting status as false and breaking the loop
 
                    status = false;
 
                    break;
                }
            }
        }
 
        //Output
 
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
}
