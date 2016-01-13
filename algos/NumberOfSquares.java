/*
 * If you have an nxn grid, how many squares can you see in the grid?
 *
 * For example, a 4x4 grid has 16 squares of 1 unit sides, 9 squares
 * of 2 unit sides, 4 squares of 3 unit sides and 1 square of 4 unit sides.
 * So, 4x4 grid has 16+9+4+1 = 30 squares.
 *
 * There is a formula for this, 1^2 + 2^2 + 3^2 + .... + n^2, which is sum
 * of squares of first n numbers, = n*(n+1)*(2*n+1)/6.
 * Reference: https://www.youtube.com/watch?v=LZGYDwjUwBI 
 *
 */

public class NumberOfSquares {
	public static void main(String[] args) {
		System.out.println("Number of squares in 1x1 grid are: "+getNumberOfSquares(1));
		System.out.println("Number of squares in 2x2 grid are: "+getNumberOfSquares(2));
		System.out.println("Number of squares in 3x3 grid are: "+getNumberOfSquares(3));
		System.out.println("Number of squares in 4x4 grid are: "+getNumberOfSquares(4));
		System.out.println("Number of squares in 5x5 grid are: "+getNumberOfSquares(5));
	}

	public static int getNumberOfSquares(int n) {
		return n*(n+1)*(2*n+1)/6;
	}
}
