package interview.searchingArrays;

public class SearchArrays {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 4, 8, 1, 4, 6};
        int[] arrSort = new int[] {3, 4, 7, 8, 9,11};
        int x = 8;
        //System.out.println(searchInUnSorted(arr, arr.length, x));
        //System.out.println(searchInSorted(arrSort, arrSort.length, x));
        System.out.println(count1sInSorted(new int[] {1, 1, 0, 0, 0, 0, 0}, 7));
        System.out.println(count1sInSorted(new int[] {1, 1, 1, 1, 1, 1, 1}, 7));
        System.out.println(count1sInSorted(new int[] {0, 0, 0, 0, 0, 0, 0}, 7));
        System.out.println(count1sInSorted(new int[] {1, 1, 1, 1, 0, 0, 0}, 7));
        //


    }

    //Linear Search from index 0 to length of the array
    static int searchInUnSorted(int arr[], int n, int x)
    {
        for(int i = 0;i < n;i++){
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //Binary search for Sorted Array
    static int searchInSorted(int arr[], int n, int x)
    {
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == x) {
                return 1;
            }
            if(arr[mid] < x) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    static int count1sInSorted(int arr[], int n)
    {
        int start = 0;
        int end = n-1;
        if (arr[0] == 0) {
            return 0;
        }
        if(arr[0] == 1 && arr[n-1] == 1) {
            return n;
        }
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == 1 && arr[mid+1] == 0) {
                return mid+1;
            }
            if(arr[mid] == 0) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return 0;
    }

    static long squareRoot(long x){
        int i = 1;
        while (true){
            if(i*i == x) {
                return i;
            }
            if(i*i > x) {
                return i-1;
            }
            i++;
        }


    }
}
