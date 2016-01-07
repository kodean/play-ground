/* This is about sorting strings in the order of their sorted counterparts
 * For example, if input array is ["gbi","cde","daf"], their sorted counterparts
 * are ["bgi","cde","adf"] and hence the output should be ["daf","gbi","cde"].
 * For simplicity, it is assumed that the chars are from 'a' to 'z'.
 *
 * We can use Arrays.sort, with a Comparator that looks at the sorted 
 * strings to compare. But, notice that we are sorting the strings everytime
 * they are compared to each other.
 *
 * So, if we have n strings, each of size m, the time complexity is O(n log n * m log m) = 
 * O(nm log m log n) and the space complexity is O(m), not counting the output array.
 *
 * We can do better in time than this by sorting the strings only once. The time complexity would
 * be O(nm log m + n log n) and the space complexity would be O(n), since we not have an intermediate
 * array of sorted strings.
 * 
 */

import java.util.Arrays;
import java.util.Comparator;

class StringSortBySorted {
	public static void main(String[] args) {
		String[] array = new String[]{"gbi","cde","daf"};

		System.out.println("Input Array: "+Arrays.toString(array));

                Arrays.sort(array,new SortedComparator());

		System.out.println("Output Array: "+Arrays.toString(array));
	}

	public static class SortedComparator implements Comparator<String> {
		private String sort(String str) {
			char[] letters = str.toCharArray();
			Arrays.sort(letters);
			return new String(letters);
		}

		public int compare(String one, String two) {
			return sort(one).compareTo(sort(two));
		}
	}
}
