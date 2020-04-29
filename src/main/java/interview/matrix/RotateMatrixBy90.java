package interview.matrix;

public class RotateMatrixBy90 {


    public static void main(String[] args) {
        int[][] input = new int[4][4];
        int n = input.length;
        int k =1;
        for(int i = 0; i < n;i++) {
            for (int j = 0;j < n;j++){
                input[i][j] = k++;
             }
        }

        for(int i = 0; i < n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }

        //Result
        //int[][] result = rotateInplace(input);
        int[][] result = rotateUsingExtraSpace(input);
        for(int i = 0; i < n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

    static int[][] rotateUsingExtraSpace(int[][] input) {
        int len = input.length;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len;i++){
            for (int j = 0;j < len;j++){
                temp[len-j-1][i] = input[i][j];
            }
        }
        for (int i = 0; i < len;i++){
            for (int j = 0;j < len;j++){
                input[i][j] = temp[i][j];
            }
        }

        return input;
    }

    static int[][] rotateInplace(int[][] input) {

        //Transpose
        for (int i = 0;i < input.length;i++){
            for (int j = i+1;j < input.length;j++){
                //swap input[i][j] and input[j][i]
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }
        //Reverse Columns
        for (int i = 0; i < input.length;i++){
            int low = 0;
            int high = input.length-1;
            while (low < high){
                //swap input[low][i] and input[high][i]
                int temp = input[low][i];
                input[low][i] = input[high][i];
                input[high][i] = temp;
                low++;
                high--;
            }
        }
        return input;
    }
}
