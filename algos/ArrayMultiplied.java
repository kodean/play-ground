/*
 * Given an array, return an array of same size with value of each index equal to
 * the product of all elements of original array except the current index.
 * Eg: input: [1,2,3,4] and output: [2*3*4,1*3*4,1*2*4,1*2*3]
 *
 * I maintain two arrays with partial products. The first array will have product
 * of numbers starting from 0 through current index. The second array will have
 * product of numbers start from next index through the end.
 * Eg: partialProduct1 = [1, 1*1, 1*1*2, 1*1*2*3] and partialProduct2 = [1*4*3*2, 1*4*3, 1*4, 1]
 * Product of the numbers from these two arrays will give the result.
 *
 * Complexity: O(n) in time and O(n) in space.
 *
 * Note: If you get product of all numbers and for each index, divide this product with
 * current index's number, that will give you the result as long as none of the elements is 0 and 
 * floating point round offs are not involved.
 */

import java.util.Arrays;

class ArrayMultiplied {
	public static void main(String[] args) {
		int[] inputArray = new int[]{1,2,3,4};
		int[] outputArray = multipliedArray(inputArray);

		System.out.println("Input: "+Arrays.toString(inputArray));
		System.out.println("Output: "+Arrays.toString(outputArray));
	}

	public static int[] multipliedArray(int[] array) {
		int len = array.length;

		int[] outputArray = new int[len];
		int[] partialProduct1 = new int[len], partialProduct2 = new int[len];

		partialProduct1[0] = 1;
		partialProduct2[len-1] = 1;
		for (int i=1;i<len;i++) {
			partialProduct1[i] = partialProduct1[i-1]*array[i-1];
			partialProduct2[len-i-1] = partialProduct2[len-i]*array[len-i];
		}

		for (int i=0;i<len;i++) {
			outputArray[i] = partialProduct1[i]*partialProduct2[i];
		}

		return outputArray;
	}
}


