/*
 * Given an array of positive integers and a number, find if any consecutive set of numbers in that array 
 * sum to the given number.
 */

import java.util.Arrays;

public class ArrayFindSum {
	public static void main(String[] args) {
		int[] array1 = new int[] {1,2,3,4};
		int[] array2 = new int[] {1,2,7,4};
		int[] array3 = new int[] {1,3,5};
		int[] array4 = new int[] {10,3,5,20,7,6,15,1,5};

		System.out.println(Arrays.toString(array1)+", set sums to 5? "+hasSum1(array1, 5));
		System.out.println(Arrays.toString(array1)+", set sums to 10? "+hasSum1(array1, 10));
		System.out.println(Arrays.toString(array2)+", set sums to 5? "+hasSum1(array2, 5));
		System.out.println(Arrays.toString(array3)+", set sums to 5? "+hasSum1(array3, 5));
		System.out.println(Arrays.toString(array4)+", set sums to 21? "+hasSum1(array4, 21));
		
		System.out.println();
	
		System.out.println(Arrays.toString(array1)+", set sums to 5? "+hasSum2(array1, 5));
                System.out.println(Arrays.toString(array1)+", set sums to 10? "+hasSum2(array1, 10));
                System.out.println(Arrays.toString(array2)+", set sums to 5? "+hasSum2(array2, 5));
                System.out.println(Arrays.toString(array3)+", set sums to 5? "+hasSum2(array3, 5));
                System.out.println(Arrays.toString(array4)+", set sums to 21? "+hasSum2(array4, 21));
	}
	
	// Using while loop
	public static boolean hasSum1(int[] array, int sum) {
		int i=0, j=0, curSum = 0;
		
		while (j<array.length || sum <= curSum) {
			if (sum == curSum) {
				return true;
			} else if (sum > curSum) {
				curSum += array[j];
				j++;
			} else if (i<j) {
				curSum -= array[i];
				i++;
			}
		}
		
		return false;
	}
	
	// Using a for and a while loop
	public static boolean hasSum2(int[] array, int sum) {
		int j = 0, curSum = 0;
		
		for (int i=0;i<array.length;i++) {
			curSum += array[i];
			
			while(curSum > sum && j<i) {
				curSum -= array[j];
				j++;
			}
			
			if (curSum == sum) {
				return true;
			}
		}
		
		return false;
	}
}
