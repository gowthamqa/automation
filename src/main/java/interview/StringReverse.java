package interview;

import java.util.Arrays;

public class StringReverse {

    public static void main(String[] args) {
        String name = "Gowtham";
        String result = reverseOn(name);
        System.out.println(reverseOnby2("mom"));
        System.out.println(reverseOnby2("abba"));
        System.out.println(reverseOnby2("reddy"));
        System.out.println(reverseOnby2("Gowthami"));
        System.out.println(reverseOnby2("a"));
        System.out.println(reverseOnby2(""));

    }

    static String reverseOn(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1;i>=0;i--) {
            result = result.append(s.charAt(i));
        }
        return result.toString();
    }

    static String reverseOnby2(String s) {
        char[] ar = s.toCharArray();
        int low = 0;
        int high = ar.length-1;
        while (low < high) {
            char temp = ar[low];
            ar[low] = ar[high];
            ar[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(ar);
        //return Arrays.toString(ar).replaceAll("\\[|\\]|,|\\s", "");
    }

    static boolean isPallindrome(String s) {
        char[] ar = s.toCharArray();
        int low = 0;
        int high = ar.length-1;
        while (low < high) {
            if(ar[low] != ar[high]){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
