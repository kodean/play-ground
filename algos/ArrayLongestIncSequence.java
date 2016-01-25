/*
 * Given an array (not sorted), find the longest increasing sequence in it 
 * (the elements don't have to be adjacent to each other)
 */

import java.util.Arrays;
import java.util.Collections;

public class ArrayLongestIncSequence {
	
	public static int called = 0;
	
	public static void main(String[] args) {
		int[] array = new int[] {2, 1, 4, 3, 5, 0, 8, 2, 6, 7, -1};
		System.out.println("Length of longest increasing sequence in "+Arrays.toString(array)+": "+longestIncreasingSeqLength2(array));
	}
	
	// n log n, iterative solution
	
	
	// n^2, iterative solution
	// Dynamic Programming, each element of sequenceLengths is the length of increasing sequence ending at that index.
	// Notes: Arrays.asList converts Object arrays to lists. 
	// But it converts primitive data type arrays into list of arrays with one item (array itself).
	// For example, compare the following two statements
	// 1. System.out.println(Arrays.asList(new int[] {2, 1, 4}));
	// 2. System.out.println(Arrays.asList(new Integer[] {2, 1, 4}));
	// The output is different.
	// Hence, sequenceLengths is Integer[] instead of int[] in this method.
	public static int longestIncreasingSeqLength2(int[] array) {
		Integer[] sequenceLengths = new Integer[array.length];
		Arrays.fill(sequenceLengths, 1);
		
		for (int i=0;i<array.length;i++) {
			for (int j=i+1;j<array.length;j++) {
				if (array[j] > array[i] && sequenceLengths[j] < sequenceLengths[i]+1) {
					sequenceLengths[j] = sequenceLengths[i]+1;
				}
			}
		}

		return Collections.max(Arrays.asList(sequenceLengths));
	}
}
