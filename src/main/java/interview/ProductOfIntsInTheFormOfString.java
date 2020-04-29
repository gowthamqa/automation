package interview;

public class ProductOfIntsInTheFormOfString {
	
	public static String productUsingInBuilt(String s1, String s2) {
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		return String.valueOf(a*b);
	}
	
	public static String productUsingStringBuffer(String s1, String s2) {
		String sOne = new StringBuffer(s1).reverse().toString();
		String sTwo = new StringBuffer(s2).reverse().toString();
		int result[] = new int[sOne.length() + sTwo.length()];
		for (int i = 0; i < sOne.length(); i++) {
			for (int j = 0; j < sTwo.length(); j++) {
				result[i + j] = result[i + j] + (sOne.charAt(i) - '0') * (sTwo.charAt(j) - '0');
			}
		}
		String product = "";
		for (int i = 0; i < result.length; i++) {
			int digit = result[i] % 10;
			int carry = result[i] / 10;
			if (i + 1 < result.length) {
				result[i + 1] = result[i + 1] + carry;
			}
			product = digit + product;
		}
		while (product.length() > 1 && product.charAt(0) == '0') {
			product = product.substring(1);
		}

		return product;
	}
	
	public static String productManual(String s1, String s2) {
		int lengthS1 = s1.length();
		int lengthS2 = s2.length();
		int result[] = new int[lengthS1+lengthS2];
		int i_s1 = 0;
		int i_s2 = 0;
		
		for(int i = lengthS1-1;i >= 0;i--) {
			int carry = 0;
			int n1 = s1.charAt(i)-'0';
			i_s2 = 0;
			for(int j = lengthS2-1;j >= 0;j--) {
				int n2 = s2.charAt(j)-'0';
				int sum = n1*n2+result[i_s1+i_s2]+carry;
				carry = sum/10;
				result[i_s1+i_s2] = sum%10;
				i_s2++;
			}
			if (carry > 0) {
				result[i_s1 + i_s2] = result[i_s1 + i_s2]+carry;
			}   
			i_s1++;		
		}
		// ignore '0's from the right 
	    int i = result.length - 1; 
	    while (i >= 0 && result[i] == 0) {
	    	i--;
	    }
		if (i == -1) {
			return "0";
		}
		// genercharAte the result String
		String s = "";

		while (i >= 0) {
			s = s+result[i--];
		}		
		return s;
	}
	
	public static void main(String[] args) {
		//System.out.println(productUsingInBuilt("2", "3"));
		System.out.println(productUsingInBuilt("123456", "98765"));
		System.out.println(productManual("123456", "98765"));
		System.out.println(productUsingStringBuffer("123456", "98765"));
		//System.out.println(1/10+"    "+1%10);
		//System.out.println(2/10+"    "+2%10);
		//System.out.println(3/10+"    "+3%10);
		//System.out.println(34/10+"    "+34%10);
		//System.out.println(7/10+"    "+7%10);
	}

}
