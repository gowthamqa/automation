package interview;

public class LeftRotationArray {
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int noOfRotations = 4;
		/*
		for(int n = 1;n <= noOfRotations;n++) {
			int temp = arr[0];
			for(int i = 0;i < arr.length;i++) {
				if(i == arr.length-1) {
					arr[i] = temp;
				}else {
					arr[i] = arr[i+1];
				}
			}
		}*/
		int ar[] = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			int index = (i+arr.length-noOfRotations)%arr.length;
			ar[index] = arr[i];
		}
		for(int a : ar) {
			System.out.print(a+", ");
		}
		usingTempArray(arr,noOfRotations);
	}
	
	public static void usingTempArray(int a[], int d) {
		int[] temp = new int[d];
		for(int i = 0;i<temp.length;i++) {
			temp[i] = a[i];
		}
	}

}
