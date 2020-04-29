package interview.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ans;
        ans = sortBubble(new int[]{2, 6, 1, 4, 9, 3, 5});
        for (int i = 0; i < ans.length;i++) {
            System.out.print(ans[i]+", ");
        }
        System.out.println();
        ans = sortBubble(new int[]{-7,4,2,0,8,3,5});
        for (int i = 0; i < ans.length;i++) {
            System.out.print(ans[i]+", ");
        }

    }

    static int[] sortBubble(int[] nums) {
        for (int i = 0; i < nums.length;i++) {
            for(int j = i+1; j < nums.length;j++) {
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
