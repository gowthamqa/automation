package interview;

public class MinimumAbsoluteDifferenceInArray {
	
	public static void main(String[] args) {
		System.out.println(minDiff(new int[] {5, 8, 4, 2, 9, 0}));
		System.out.println(minDiff(new int[] {45, -89, 12, -62, 31, -57}));
		System.out.println(minDiff(new int[] {5, -3, 7, -2}));
	}
	
	public static int minDiff(int[] ar) {
		int minimum = Math.abs(ar[0]-ar[1]);
		for(int i = 1;i < ar.length;i++) {
			for(int j = i+1;j < ar.length;j++) {
				if(Math.abs(ar[i]-ar[j]) < minimum) {
					minimum = Math.abs(ar[i]-ar[j]);
				}
			}
		}
		return minimum;
	}
}
