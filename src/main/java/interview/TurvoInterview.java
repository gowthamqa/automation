package interview;

public class TurvoInterview {

    public static void main(String[] args) {
        System.out.println((int)('a'));
        System.out.println(attemptsToReach(10));
        System.out.println(attemptsToReach(27));
        System.out.println(attemptsToReach(2));
        System.out.println(attemptsToReach(4));
        int ar[] = {67,10,12,55,-3,45,7,3};
        isLegend(ar);
        System.out.println(isAnagramXOR("CQT","ACT"));
    }

    //A monkey climbs 4 feet and falls 2 feet back. Find attempts required for monkey to reach fruit which is n feet high
    public static int attemptsToReach(int height){
        int attempts = 0;
        int tempHeight = 0;
        if(height <= 4 ){
            return 1;
        }
        while(height > 0){
            attempts++;
            tempHeight = tempHeight+4;
            if(tempHeight >= height){
                break;
                //return attempts;
            }else{
                tempHeight = tempHeight-2;
            }
        }
        return attempts;
    }

    //Legend is a number which don't have any numbers greater than itself towards its left. Identify legends
    public static void isLegend(int ar[]){
        for(int i = 0;i<ar.length;i++){
            int temp = ar[i];
            boolean flag = false;
            for(int j = i+1;j<ar.length;j++){
                if(temp < ar[j]){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println(ar[i]);
            }
        }
    }

    //Check given two String are Anagrams
    public static boolean isAnagrams(String s1, String s2){
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        if(s1.length()!=s2.length()) {
            return false;
        }
        if(s1.length() == 0 || s2.length() == 0){
            return true;
        }
        for(int i = 0;i < s1.length();i++){
            if(s2.indexOf(s1.charAt(i)) == -1){
                return false;
            }else {
                s2 = s2.substring(0,s2.indexOf(s1.charAt(i)))+s2.substring(s2.indexOf(s1.charAt(i))+1);
            }
        }
        return true;
    }

    static boolean isAnagramXOR(String s1, String s2) {
        char[] ars1 = s1.toCharArray();
        char[] ars2 = s2.toCharArray();
        int xor = 0;
        for (int i = 0; i<ars1.length;i++){
            xor ^= ars1[i] ^ ars2[i];
        }
        if (xor == 0)
            return true;
        else
            return false;
    }

}
