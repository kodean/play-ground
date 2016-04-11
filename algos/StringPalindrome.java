/*
 * Check if given string is a palindrome.
 */

public class StringPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("abc"));
		System.out.println(isPalindrome("abcba"));
		System.out.println(isPalindrome("abba"));
	}

	private static boolean isPalindrome(String str) {
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}

		return true;
	}
}
