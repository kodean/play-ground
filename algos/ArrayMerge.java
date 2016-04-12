/*
 * Merge two sorted arrays, preserving the sorted order.
 */

import java.util.Arrays;

public class ArrayMerge {
	public static void main(String[] args) {
		int[] one = new int[] { 1, 3, 5 };
		int[] two = new int[] { 2, 4, 6 };

		System.out.println(Arrays.toString(mergeSortedArrays(one,two)));
	}

	public static int[] mergeSortedArrays(int[] one, int[] two) {
		int len1 = one.length, len2 = two.length;
		int[] array = new int[len1+len2];

		int i=0, j=0, k=0;
		while (i < len1 && j < len2) {
			if (one[i] <= two[j]) {
				array[k++] = one[i++];
			} else {
				array[k++] = two[j++];
			}
		}
		while (i < len1) {
			array[k++] = one[i++];
		}
		while (j < len2) {
			array[k++] = two[j++];
		}

		return array;
	}
}
