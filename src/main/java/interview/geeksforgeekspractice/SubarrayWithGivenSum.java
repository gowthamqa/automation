package interview.geeksforgeekspractice;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        //int[] result = bootStarp(new int[]{1, 2, 3, 7, 5},12); // 2,4
        //int[] result = bootStarp(new int[]{1, 4, 0, 0, 3, 10, 5},7); // 1,4
        int[] result = bootStarp(new int[]{15, 2, 4, 8, 9, 5, 10, 23},23); // 1,4
        //int[] result = bootStarp(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},15); //1,5
        //
        for (int s  : result) {
            System.out.println(s);
        }


    }

    static int[] bootStarp(int[] nums, int sum) {
       int[] result = new int[2];
       int currSum;
       for (int i = 0;i < nums.length;i++) {
           currSum = nums[i];
           for (int j = i+1;j <= nums.length;j++){
               if (currSum == sum) {
                   result[0] = i;
                   result[1] = j-1;
                   return result;
               }
               if (currSum > sum || j == nums.length)
                   break;
               currSum = currSum + nums[j];
           }
       }
       return new int[]{0,0};
    }


}
