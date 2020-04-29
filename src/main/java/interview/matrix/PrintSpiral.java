package interview.matrix;

public class PrintSpiral {

    public static void main(String[] args) {
        int row = 4;
        int colum = 4;
        int[][] input = new int[row][colum];
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
        printSpi(input, row,colum);
    }

    static void printSpi(int[][] input, int row, int col){
        int top = 0;
        int left = 0;
        int right = col - 1;
        int bottom = row - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <=right;i++){
                System.out.print(input[top][i]+" ");
            }
            top++;
            for (int i = top;i <=bottom;i++){
                System.out.print(input[i][right]+" ");
            }
            right--;
            if(top <= bottom){
                for (int i = right;i>=left;i--){
                    System.out.print(input[bottom][i]+" ");
                }
            }
            bottom--;
            if(left <= right){
                for (int i = bottom;i >= top;i--){
                    System.out.print(input[i][left]+" ");

                }
            }
            left++;
        }

    }
}
