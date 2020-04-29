public class TestMain {

    public static void main(String[] args) {
        int ar[] = {4,2,1};
        //System.out.println(decre(ar));
        int ar1[] = {3,4,2,3};
        System.out.println(leetAns(ar1));
        //sort(ar);
        //sort(ar1);
        int []idr = {-7, -3, 2, 3, 11};
        //int dr[] = nonDecreasingSqquare(idr);
        for (int a: idr) {
            //System.out.print(a+", ");
        }

    }

    public static boolean decre(int[] ar){
        boolean flag = true;
        int count = 0;
        for(int i = 0; i < ar.length-1;i++) {
            if(ar[i] > ar[i+1]) {
                count++;
                ar[i] = ar[i+1]-1;
                if(count > 1) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean leetAns(int[] nums){
        int pos = -1;
        for(int i=0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (pos >= 0) {
                    return false;
                }
                pos = i;
            }
        }
        if (pos == -1) {
            return true;
        }
        if (pos == 0 || pos == nums.length-2 || nums[pos-1] <= nums[pos+1] || nums[pos] <= nums[pos+2]) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void sort(int[] ar){
        for(int i = 0; i < ar.length;i++) {
            for(int j = i+1;j < ar.length;j++){
                if(ar[i] > ar[j]){
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        for (int a: ar) {
            System.out.print(a+", ");
        }
    }

    public static int[] nonDecreasingSqquare(int ar[]) {
        for (int i = 0;i < ar.length;i++) {
            ar[i] = ar[i] * ar[i];
        }
        sort(ar);
        return  ar;
    }
}
