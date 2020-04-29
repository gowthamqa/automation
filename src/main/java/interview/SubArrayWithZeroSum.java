package interview;

import java.util.HashSet;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        System.out.println(zeroSum(new int[]{3,-2,-1,5}));
        System.out.println(zeroSum(new int[]{1,4,13,-3,-10,5}));

    }

    static boolean zeroSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int currSum = 0;
        for (int i = 0;i < nums.length;i++){
            currSum = currSum + nums[i];
            if(currSum == 0){
                return true;
            }
        }
        return true;
    }
}
