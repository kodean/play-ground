/*
 * Return the most frequently appearing element in a given array.
 */

import java.util.HashMap;

public class ArrayMostFrequent {
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 2, 3, 1, 5, 7, 2, 9, 2, 5 };

		System.out.println(getMostFrequentElement(array));
	}

	// O(n) in time and O(n) in space.
	public static <T> T getMostFrequentElement(T[] array) {
		int highestFrequency = 0;
		T mostFrequentElement = null;

		HashMap<T,Integer> map = new HashMap<T,Integer>();

		for (T element : array) {
			if (map.containsKey(element)) {
				map.put(element,map.get(element)+1);
			} else {
				map.put(element,1);
			}

			if (map.get(element) > highestFrequency) {
                                highestFrequency = map.get(element);
                                mostFrequentElement = element;
                        }
		}

		return mostFrequentElement;
	}
}
