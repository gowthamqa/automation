package interview;

public class CheckkingArithmeticProgressionArray {

    public static void main(String[] args) {
        System.out.println(isAP(new int[] {2, 6, 10, 15, 19, 23}));
        System.out.println(isAP(new int[] {2, 6, 10, 14, 18, 22}));

    }

    static boolean isAP(int[] nums) {
        int check = nums[1] - nums[0];
        for (int i = 1;i < nums.length-1;i++){
            if(nums[i+1] - nums[i] != check){
                return false;
            }
        }
        return true;
    }
}
