import java.util.Arrays;

public class StringAnagrams {
	public static void main(String[] args) {
		System.out.println(anagram2("",""));
		System.out.println(anagram2("ab","abc"));
		System.out.println(anagram2("abc","def"));
		System.out.println(anagram2("abc","bac"));
		System.out.println(anagram2("abcdefghi","gadbfiche"));
		
		System.out.println();
		
		System.out.println(anagram3("",""));
		System.out.println(anagram3("ab","abc"));
		System.out.println(anagram3("abc","def"));
		System.out.println(anagram3("abc","bac"));
		System.out.println(anagram3("abcdefghi","gadbfiche"));
	}
	
	// linear in time, linear in space
	// Need to finish iterating through both strings in all cases
	// Two empty strings are anagrams
	public static boolean anagram2(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
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
	
	// linear in time, linear in space
	// We can iterate through one string and exit as soon as we find a mismatch
	// Two empty strings are NOT anagrams
	public static boolean anagram3(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		if (str1.length() != str2.length()) {
			return false;
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
