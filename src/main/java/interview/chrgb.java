package interview;

public class chrgb {

        public static void main(String[] args) {
            System.out.println(roundTwo(""));
            int[] result = roundOneOptimized(new int[] {-13,-12,-11,0,11,12,13});
            for (int a : result) {
                System.out.println(a);
            }
        }

        /**
         * Write fiction that takes array in as input and return array int whose product is max
         * Input: [-13,-12,-11,0,11,12,13] output [-13,-12,13]
         * [1,2,3,4,5] = [3,4,5]
         *
         */
        static int[] roundOneAnswered(int[] input) {
            int result[] = new int[3];
            int length = input.length;
            int maxProduct = Integer.MIN_VALUE;
            for (int i = 0; i < length-2;i++){
                for (int j = i+1; j < length-1;j++){
                    for (int k = j+1; k < length;k++) {
                        int temp = input[i] * input[j] * input[k];
                        if (maxProduct < temp) {
                            maxProduct = temp;
                            result[0] = input[i];
                            result[1] = input[j];
                            result[2] = input[k];
                        }
                    }
                }
            }
            return result;
        }

        static int[] roundOneOptimized(int[] arr){
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
        /**
         * Input "wwwaaaabbbcdwa"
         * Output "w3a4b3c1d1w1a1"
         *
         **/
        static String roundTwo(String input) {
            if (input == null || input.equals("")){
                return "";
            }
            String result = "";
            int count = 1;
            char[] character = input.toCharArray();
            for(int i = 0;i < character.length-1;i++){
                if(character[i] != character[i+1]){
                    result = result+character[i]+count;
                    count = 1;
                }else {
                    count++;
                }
            }
            result = result+character[character.length-1]+count;
            return result;
        }

}
