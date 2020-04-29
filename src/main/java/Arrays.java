public class Arrays {

    public static void main(String[] args) {
        int ar[] = {3, 7, 2, 1, 20};
        //int ar[] = {0, 0 ,0};
        //int result[] = reverse(ar);
        //int result[] = leftRotateBy1(ar);
        int result[] = leftRotateBykplaces(ar,3);
        for (int num : result) {
            //System.out.print(num+", ");
        }
        System.out.println(totalNoSubArraysWhoseSumEqualsToK(ar, 10));
    }

    public static int[] reverse(int[] ar) {
        int low = 0;
        int high = ar.length-1;
        while (low < high) {
            int temp = ar[low];
            ar[low] = ar[high];
            ar[high] = temp;
            low++;
            high--;
        }
        return ar;
    }

    public static int[] leftRotateBy1(int[] ar) {
        int temp = ar[0];
        for(int i = 1;i<ar.length;i++){
            ar[i-1] = ar[i];
        }
        ar[ar.length-1] = temp;
        return ar;
    }

    public static int[] leftRotateBykplaces(int[] ar, int k) {
        //Method 1
        int temp[] = new int[k];
        for (int i = 0; i < k;i++) {
            temp[i] = ar[i];
        }
        int n = 0;
        for (int i = k;i < ar.length;i++) {
            ar[n] = ar[i];
            n++;
        }
        for (int i = 0;i<k;i++) {
            ar[n] = temp[i];
        }
        return ar;
        //Method 2
        /*int n = ar.length;
        int result[] = new int[n];
        for(int i = 0;i<ar.length;i++){
            result[(i+n-k)%n] = ar[i];
        }
        return result;*/
    }

    public static int totalNoSubArraysWhoseSumEqualsToK(int[] arr, int k) {
        int totalCount = 0;
        for (int i = 0;i < arr.length;i++) {
            int[] temp = new int[i+1];
            for (int j = 0;j<temp.length;j++) {
                temp[j] = arr[i];
            }
            int sum = 0;
            for (int j = 0;j<temp.length;j++) {
                sum = sum + temp[j];
            }
            if (sum == k) {
                totalCount++;
            }
        }
        return totalCount;
    }
}
