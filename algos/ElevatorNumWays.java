/*
 * You have an elevator that can only go 1 level up or 2 levels up. It can't go down.
 * In how many ways can you go to level n from level 1, using the two choices? 
 * 
 * The answer turns out to be nth number in fibonacci series. This is because,
 * number of ways you can get to n = number of ways you can get to n-1 + number
 * of ways you can get to n-2.
 *
 * Note 1: This will print number of ways to go from floor 1 to floor 1 as 1.
 *
 * Note 2: Another fun problem would be if elevator can go up by any number of 
 * levels, but can't go down, how many ways can you go to level n? In this case
 * number of ways you can get to n = number of ways you can get to n-1 + number
 * of ways you can get to n-2 + ...... + number of ways you can get to level 1.
 * 
 */

public class ElevatorNumWays {
	public static void main(String[] args) {
		System.out.println("Number of ways to get to 3rd floor: "+getFibonacci(3));
		System.out.println("Number of ways to get to 4th floor: "+getFibonacci(4));
		System.out.println("Number of ways to get to 5th floor: "+getFibonacci(5));
	}

	public static int getFibonacci(int n) {
		int first = 0, second = 1, sum = 1;
		for (int i=0;i<n;i++) {
			first = second;
			second = sum;
			sum = first+second;
		}
		return first;
	}
}
