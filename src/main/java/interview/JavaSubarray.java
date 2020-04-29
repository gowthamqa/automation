package interview;

import java.util.HashMap;

public class JavaSubarray {

	public static void main(String[] args) {
		int ar[] = { 1, -2, 4, -5, 1 };
		int noOfnegative = 0;
		for(int i = 1;i<=ar.length;i++) {
			int temp[] = new int[i];
			//for(int j = 0;j < temp.length;j++) {
			//	temp[j] = ar[j];
			//}
			int result = 0;
			for (int j = 0; j < temp.length; j++) {
				result = result + ar[j];
			}
			if(result<0) {
				noOfnegative++;
			}
		}
		
		System.out.println(noOfnegative);
	}

	static int noOfSub(int[] ar) {
		int result = 0;
		HashMap<Integer, Integer> prevSum = new HashMap<>();
		int currSum = 0;
		for (int i = 0;i < ar.length;i++) {
			currSum = currSum + ar[i];
			if(currSum < 0) {
				result++;
			}
			//if(prevSum.containsKey(currSum-))

		}
		return result;
	}
	

}
