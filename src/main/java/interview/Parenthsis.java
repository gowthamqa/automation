package interview;

public class Parenthsis {

    public static void main(String[] args) {

        System.out.println(isParenthsisStack("{{[]}}"));

    }

    static boolean isParenthsisStack (String s) {
        char[] ar = s.toCharArray();
        int xor = 0;
        for (int i = 0; i< ar.length;i++) {
            xor = xor ^ ar[i];
        }
        if (xor == 0)
        return true;
        else
            return false;
    }
}
