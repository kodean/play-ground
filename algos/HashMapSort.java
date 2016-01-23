/*
 * Sort keys of a HashMap, using it's values
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HashMapSort {
	public static void main(String[] args) {
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		hashMap.put("c",3);
		hashMap.put("b",2);
		hashMap.put("a",1);

		System.out.println(sortHashMap(hashMap));
	}

	public static ArrayList<String> sortHashMap(final HashMap<String,Integer> hashMap) {
		ArrayList<String> keys = new ArrayList<String>(hashMap.keySet());

		Collections.sort(keys, new Comparator<String>() {
			public int compare(String str1, String str2) {
				return hashMap.get(str1).compareTo(hashMap.get(str2));
			}
		});

		return keys;
	}
}
