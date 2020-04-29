package interview;

public class FindNumberOfOccurancesOfTargetValueInSortedIntegerArray {

    public static void main(String[] args) {
        //System.out.println(nuOfOccurance(new int[]{5, 7, 7, 8, 8, 8, 10}, 8));
        System.out.println(bootStrap(new int[]{5, 7, 7, 8}, 7));

    }

    public static int bootStrap(int[] nums, int target) {
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0;i < nums.length;i++) {
            if(nums[i] == target && count == 0) {
                start = i;
                count = 1;
            }else if(nums[i] == target){
                end = i;
            }
        }
        return end-start;
    }

    public static int nuOfOccurance(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + high /2;
            if(nums[mid] == target && nums[mid-1] != target){
                low = mid;
            }if(nums[mid] == target && nums[mid+1] != target){
                high = mid;
            }
            if (nums[low] == target && nums[high] == target) {
                break;
            }
        }
        return high-low;
    }
}
