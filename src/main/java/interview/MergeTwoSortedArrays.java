package interview;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] arrayA = new int[] {-7, 12, 17, 29, 41, 56, 79};
        
        int[] arrayB = new int[] {-9, -3, 0, 5, 19};
         
        int[] mergedArray1 = mergeArray(arrayA, arrayB);
        
        int[] mergedArray2 = mergeAndSort(arrayA, arrayB);
         
        System.out.println("Array A : "+Arrays.toString(arrayA));
         
        System.out.println("Array B : "+Arrays.toString(arrayB));
         
        System.out.println("Merged Array : "+Arrays.toString(mergedArray1));
        
        System.out.println("Merged Array : "+Arrays.toString(mergedArray2));
	}
	
	public static int[] mergeAndSort(int[] arrayA, int[] arrayB) {
		int mergedArray[] = new int[arrayA.length+arrayB.length];
		int k = 0;
		for(int i = 0;i<arrayA.length;i++) {
			mergedArray[k] = arrayA[i];
			k++;
		}
		for(int i = 0;i<arrayB.length;i++) {
			mergedArray[k] = arrayB[i];
			k++;
		}
		
		for(int i = 0;i<mergedArray.length;i++) {
			for(int j = i+1;j<mergedArray.length;j++) {
				if(mergedArray[i] > mergedArray[j]) {
					int temp = mergedArray[i];
					mergedArray[i] = mergedArray[j];
					mergedArray[j] = temp;
				}
			}
		}
		
		return mergedArray;
	}
	
	public static int[] mergeArray(int[] arrayA, int[] arrayB) {
		int mergedArray[] = new int[arrayA.length+arrayB.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < arrayA.length && j < arrayB.length) {
			if(arrayA[i] < arrayB[j]) {
				mergedArray[k] = arrayA[i];
				i++;
				k++;
			}else {
				mergedArray[k] = arrayB[j];
				j++;
				k++;
			}
		}
		
		while(i < arrayA.length) {
			mergedArray[k] = arrayA[i];
			i++;
			k++;
		}
		
		while(j < arrayB.length) {
			mergedArray[k] = arrayB[j];
			j++;
			k++;
		}
		return mergedArray;
	}

}
