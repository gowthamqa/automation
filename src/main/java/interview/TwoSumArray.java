package interview;

import java.util.HashSet;

public class TwoSumArray {
	
	public static void twoValWithEXtraMemory(int arr[], int target) {
		HashSet<Integer> hset = new HashSet<Integer>();		
		for(int i = 0;i<arr.length;i++) {
			int difference = target - arr[i];
			if(hset.contains(difference)) {
				System.out.print(difference+" + "+arr[i]+" = "+target);
				System.out.println();
			}else {
				hset.add(arr[i]);
			}	
		}
	}
	
	public static void twoValNoEXtraMemory(int arr[], int target) {
		int first = 0;
		int last = arr.length-1;
		boolean flag = false;
		for(int i = 0;i<arr.length;i++) {
			int sum = arr[first] + arr[last];
			if(sum == target) { 
				System.out.print(arr[first]+"   "+arr[last]);
				flag = true;
				break;	
			}else {
				if(sum > target) {
					last--;
				}else if(sum < target) {
					first++;
				}
			}	
		}
		if(!flag) {
			System.out.println("No Such integers availabe");
		}				
	}
	
	public static void main(String[] args) {
		int[] input = {3,5,6,8,9};
		//twoValWithEXtraMemory(input, 13);
		twoValNoEXtraMemory(input, 13);
	}

}
