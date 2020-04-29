package interview;

public class In {

    public static void main(String[] args) {
        //int[] r = maxProdSort(new int[]{-13,-12,-11,0,11,12,13});
        int[] r = maxProdSort(new int[]{1,2,3,4,5});
        for (int a : r){
            System.out.println(a);
        }
    }

    static int[] maxProd(int[] arr){
        int n = arr.length;
        int[] result = new int[3];
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++){
                    int temp = arr[i] * arr[j] * arr[k];
                    if(maxProduct < temp){
                        maxProduct = temp;
                        result[0] = arr[i];
                        result[1] = arr[j];
                        result[2] = arr[k];
                    }
                }
            }
        }
        return result;
    }
    static int[] maxProdSort(int[] arr){
        int n = arr.length;
        int[] result = new int[3];
        int prodLeft = arr[0]* arr[1]*arr[n-1];
        int prodRight = arr[n-1]*arr[n-2]*arr[n-3];
        if (prodLeft <= prodRight) {
            result[0] = arr[n-3];
            result[1] = arr[n-2];
            result[2] = arr[n-1];
        }else {
            result[0] = arr[0];
            result[1] = arr[1];
            result[2] = arr[n-1];
        }
        return result;
    }
}
