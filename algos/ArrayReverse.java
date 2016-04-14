/*
 * Reverse an array in place.
 *
 * Note: We are using generic method, hence the use of Integer[] as opposed to int[] (since int[] doesn't extend Object[]).
 * 
 */

import java.util.Arrays;

public class ArrayReverse {
	public static void main(String[] args) {
		Integer[] array1 = new Integer[] {1, 2, 3}; 
		Integer[] array2 = new Integer[] {1, 2, 3, 4};
		
		reverseArray(array1);
		reverseArray(array2);

		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
	}

	public static <T> void reverseArray(T[] array) {
		int len = array.length;

		for (int i=0;i<len/2;i++) {
			T temp = array[i];
			array[i] = array[len-i-1];
			array[len-i-1] = temp;
		}
	}
}
