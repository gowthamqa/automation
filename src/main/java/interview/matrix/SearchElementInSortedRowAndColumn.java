package interview.matrix;

public class SearchElementInSortedRowAndColumn {

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
        bootStapSearch(input, 89);
        bootStapSearch(input, 4);
        bootStapSearch(input, 6);
        bootStapSearch(input, 11);
        bootStapSearch(input, 13);
        efficientWay(input, row,colum, 89);
        efficientWay(input, row,colum, 4);
        efficientWay(input, row,colum, 6);
        efficientWay(input, row,colum, 11);
        efficientWay(input, row,colum, 13);

    }

    static void bootStapSearch(int[][] input,int s){
        for(int i = 0; i < input.length;i++) {
            for (int j = 0; j < input.length; j++) {
                if(input[i][j] == s){
                    System.out.println(i +" and "+j);
                    return;
                }
            }
        }
        System.out.println("Not found");
    }

    static void efficientWay(int[][] input,int row, int col, int s){
        int i = 0;
        int j = col-1;
        while (i < row && j >= 0) {
            if(input[i][j] == s) {
                System.out.println(i + " and "+ j);
                return;
            }
            if(input[i][j] < s){
                i++;
            }else {
                j--;
            }
        }
        System.out.println("Not found");
    }



}
