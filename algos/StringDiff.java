/*
 * Print diff between two strings similar to the way the diff utility does between files:
 * how to modify first string into second string?
 *
 * diff operation is based on solving longest common subsequence of the two strings.
 * It boils down to two steps.
 * Step 1: Build the Dynamic Programming LCS matrix
 * Step 2: Use the matrix to figure out the letters to be deleted and added.
 *
 */

class StringDiff {
	public static void main(String[] args) {
		String str1 = "abcdefghijkl";
		String str2 = "a12bc234bcdef20384jkl";

		System.out.println("Input: \""+str1+"\" and \""+str2+"\", diff:");
		diff(str1,str2);
		diff(str2,str1);
	}

	public static void diff(String str1, String str2) {
		// Step 1
		int len1 = str1.length(), len2 = str2.length();

                int[][] matrix = new int[len1+1][len2+1];

                for (int i=1;i<=len1;i++) {
                        for (int j=1;j<=len2;j++) {
                                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                                        matrix[i][j] = 1+matrix[i-1][j-1];
                                } else {
                                        matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                                }
                        }
                }

		// Step 2
		int i=1, j=1;
		while (i<=len1 || j<=len2) {
			if (i<=len1 && j<=len2 && str1.charAt(i-1) == str2.charAt(j-1)) {
				System.out.print(str1.charAt(i-1));
				i++;
				j++;
			} else if (j==len2 || matrix[i+1][j] > matrix[i][j+1]) {
                                System.out.print("(-"+str1.charAt(i-1)+")");
				i++;
			} else if (i==len1 || matrix[i+1][j] <= matrix[i][j+1]) {
                                System.out.print("(+"+str2.charAt(j-1)+")");
				j++;
			}
		}
		System.out.println();
	}
}
