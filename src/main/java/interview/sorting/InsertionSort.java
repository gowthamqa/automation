package interview.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] ans;
        ans = sortInsertion(new int[]{2, 6, 1, 4, 9, 3, 5});
        for (int i = 0; i < ans.length;i++) {
            System.out.print(ans[i]+", ");
        }
        System.out.println();
        ans = sortInsertion(new int[]{-7,4,2,0,8,3,5});
        for (int i = 0; i < ans.length;i++) {
            System.out.print(ans[i]+", ");
        }

    }

    static int[] sortInsertion(int[] nums) {
        for (int i = 1;i < nums.length;i++) {
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
        return nums;
    }

}


