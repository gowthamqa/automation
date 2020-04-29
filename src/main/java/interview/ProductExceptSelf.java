package interview;

public class ProductExceptSelf {

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4,5});
    }

    public static void productExceptSelf(int[] nums) {
        int[] ar = {1,2,3,4,5};
        int[] L = new int[ar.length];
        int[] R = new int[ar.length];
        int[] ans = new int[ar.length];
        L[0] = 1;
        for (int i = 1;i<ar.length;i++) {
            L[i] = L[i-1]*ar[i-1];
        }
        R[ar.length-1] = 1;
        for (int i = ar.length-2;i>=0;i--) {
            R[i] = R[i+1]*ar[i+1];
        }

        for (int i = 0; i < ar.length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            ans[i] = L[i] * R[i];
        }

        for (int t : ans){
            System.out.println(t);
        }

        //return new int[]{};
    }
}
