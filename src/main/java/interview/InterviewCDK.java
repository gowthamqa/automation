package interview;

public class InterviewCDK {

    public static void main(String[] args) {
        System.out.println(factorialRecursion(5));

    }

    static int factorialRecursion(int n) {
        int result = 1;
        if (n == 1){
            return 1;
        }
        result = n * factorialRecursion(n-1);
        return result;
        //return n*factorialRecursion(n-1);
    }
    //sort Array
    //Create array from duplicates exist in the given Array [-1, 2, 3, -1, 2, 4, 5, 2 ] —> [-1,2]
 }
