/*
 * Given two strings, determine if they are anagrams of each other or not.
 * You can assume that strings only contain ascii chars (0 to 255).
 * 
 * 1. Sort and compare: You can sort them and compare. O(n log n) in time, O(n) in space
 * 2. Count chars together: Count number of occurrences of chars in both strings and compare.
 *    O(n) in time and O(1) in space 
 * 3. Count and check: Count number of occurrences of chars in one string first. While going 
 *    through second string, we can exit as soon as we find a mismatch.
 *    O(n) in time and O(1) in space
 *
 * I like approch #2. It is much simpler than #3 and has same time and space complexity.
 *
 */

import java.util.Arrays;

public class StringAnagrams {
	public static void main(String[] args) {
		String[] inputs1 = new String[] {"","ab","abc","abc","abcdefghi"};
		String[] inputs2 = new String[] {"","abc","def","bac","gadbfiche"};

		System.out.println("Sort and compare:");

		for (int i=0;i<inputs1.length;i++) {
			System.out.println("\""+inputs1[i]+"\" & \""+inputs2[i]+"\": "+sortAndCompare(inputs1[i],inputs2[i]));
		}
		
		System.out.println("Count chars together:");
		
		for (int i=0;i<inputs1.length;i++) {
                        System.out.println("\""+inputs1[i]+"\" & \""+inputs2[i]+"\": "+countChars(inputs1[i],inputs2[i]));
                }
		
		System.out.println("Count and check:");

		for (int i=0;i<inputs1.length;i++) {
                        System.out.println("\""+inputs1[i]+"\" & \""+inputs2[i]+"\": "+countAndCheck(inputs1[i],inputs2[i]));
                }
		
	}
	
	public static boolean sortAndCompare(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] array1 = str1.toCharArray();
		char[] array2 = str2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);

		return Arrays.equals(array1,array2);
	}

	public static boolean countChars(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		int[] counter1 = new int[256];
		int[] counter2 = new int[256];
		
		for (int i=0;i<str1.length();i++) {
			counter1[str1.charAt(i)]++;
			counter2[str2.charAt(i)]++;
		}

		return Arrays.equals(counter1,counter2);
	}
	
	public static boolean countAndCheck(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		} else if (str1.length() == 0) {
			return true;
		}
		
		int[] counter = new int[256];
		int numUniques = 0; // total number of chars in the string, not counting duplicates.
		
		for (char c : str1.toCharArray()) {
			if (counter[c] == 0) {
				numUniques++;
			}
			counter[c]++;
		}
		
		int numCompleted = 0; // number of chars accounted for.
		for (int i=0;i<str2.length(); i++) {
			char c = str2.charAt(i);
			if (counter[c] == 0) {
				return false;
			}
			counter[c]--;
			if (counter[c] == 0) {
				numCompleted++;
				
				if (numCompleted == numUniques) { // accounted all chars
					return (i == str2.length()-1); // are we done with str2? If yes, they are anagrams. If no, we have more chars in str2, so not anagrams.
				}
			}
			
		}
		
		return false;
	}
}
