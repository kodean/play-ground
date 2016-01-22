/*
 * Given two strings, check if one of them is a rotaion of another.
 * 
 * Append one of the strings to itself and check if the second string
 * is a substring of the result. Of course, you don't have to explicitly
 * append as shown below, but you only need one line of code this way.
 * 
 */

public class StringRotation {
	public static void main(String[] args) {
		String str1 = "abcd", str2 = "cdab", str3 = "bacd";
		
		System.out.println(str1+", "+str2+": "+isRotation(str1,str2));
		System.out.println(str1+", "+str3+": "+isRotation(str1,str3));
	}
	
	public static boolean isRotation(String str1, String str2) {
		return (str1+str1).contains(str2);
	}
}
