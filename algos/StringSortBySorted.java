/* This is about sorting strings in the order of their sorted counterparts
 * For example, if input array is ["gbi","cde","daf"], their sorted counterparts
 * are ["bgi","cde","adf"] and hence the output should be ["daf","gbi","cde"].
 * For simplicity, it is assumed that the chars are from 'a' to 'z'.
 *
 * I like to use Arrays.sort, with a Comparator that looks at the sorted 
 * strings to compare.
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
