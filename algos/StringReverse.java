/*
 * Reverse a String.
 * 
 * String is immutable in Java. So, there is no such thing as reversing
 * the String in-place.
 *
 */

public class StringReverse {
	public static void main(String[] args) {
		System.out.println("Reverse of null: "+reverseString1(null));
		System.out.println("Reverse of \"\": "+reverseString1(""));
		System.out.println("Reverse of \"a\": "+reverseString1("a"));
		System.out.println("Reverse of \"abc\": "+reverseString1("abc"));
		System.out.println("Reverse of \"abcd\": "+reverseString1("abcd"));
		
		System.out.println();
	
                System.out.println("Reverse of null: "+reverseString2(null));
                System.out.println("Reverse of \"\": "+reverseString2(""));
                System.out.println("Reverse of \"a\": "+reverseString2("a"));
                System.out.println("Reverse of \"abc\": "+reverseString2("abc"));
                System.out.println("Reverse of \"abcd\": "+reverseString2("abcd"));	
	}

	// Using char array
	public static String reverseString1(String str) {
		if (str == null) {
			return null;
		}
		
		char[] strArray = str.toCharArray();
		for (int i=0;i<strArray.length/2;i++) {
			int offSet = strArray.length-i-1;
			char temp = strArray[i];
			strArray[i] = strArray[offSet];
			strArray[offSet] = temp;
		}
		
		return new String(strArray);
	}
	
	// Using StringBuilder
	public static String reverseString2(String str) {
		if (str == null) {
			return null;
		}
		
		StringBuilder strBuilder = new StringBuilder(str);
		
		// If you don't want to use StringBuilder's reverse, you can use setCharAt method to 
		// reverse StringBuilder the way char array was reversed above.
		return strBuilder.reverse().toString();
	}
}
