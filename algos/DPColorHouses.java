/*
 *
 * There are three colors of varying costs to paint with.
 * There are n houses of varying sizes to paint. Adjacent houses should not have same color.
 * What is the minimum cost of painting all the houses.
 *
 * Solution 1: naive recursive solution. 
 *
 * Solution 2: In above solution, we are computing prices for set of houses given a starting color 
 * again and again. Use memoization to avoid computing the same thing repeatedly. Basically, remember 
 * min cost of painting a house for each color (3xn matrix).
 *
 * Solution 3: Use dynamic programmin, i.e., fill up the matrix from Solution 2 iteratively.
 *
 */

public class DPColorHouses {
	public static void main(String[] args) {
		int[] colorCosts = new int[] { 2, 5, 8 };
		int[] houseSizes = new int[] { 1000, 2000, 3000, 500 };
		
		System.out.println(getMinPaintCost3(houseSizes, colorCosts));
		System.out.println(getMinPaintCost2(houseSizes, colorCosts, 0, -1, new int[3][houseSizes.length]));
		System.out.println(getMinPaintCost1(houseSizes, colorCosts, 0, -1));
	}
	
	// Solution 3: O(n) Iterative + Memoization (Dynamic Programming) solution
	public static int getMinPaintCost3(int[] houseSizes, int[] colorCosts) {
		int[][] computedMinCosts = new int[colorCosts.length][houseSizes.length];
		
		for (int i=0;i<colorCosts.length;i++) {
			computedMinCosts[i][0] = colorCosts[i]*houseSizes[0];
		}
		
		for (int i=1;i<houseSizes.length;i++) {
			for (int j=0;j<colorCosts.length;j++) {
				computedMinCosts[j][i] = colorCosts[j]*houseSizes[i]+Math.min(computedMinCosts[(j+1)%3][i-1], computedMinCosts[(j+2)%3][i-1]);
			}
		}
		
		return Math.min(computedMinCosts[0][houseSizes.length-1], Math.min(computedMinCosts[1][houseSizes.length-1],computedMinCosts[2][houseSizes.length-1]));
	}
	
	// Solution 2: O(n) Recursive + Memoization solution
	public static int getMinPaintCost2(int[] houseSizes, int[] colorCosts, int curHouseIndex, int previousCostIndex, int[][] computedMinCosts) {
		if (curHouseIndex == houseSizes.length-1) {
			return Math.min(houseSizes[curHouseIndex]*colorCosts[(previousCostIndex+1)%3], houseSizes[curHouseIndex]*colorCosts[(previousCostIndex+2)%3]);
		}
		
		int minCost = Integer.MAX_VALUE;

		for (int i=0;i<2;i++) {
			if (i != previousCostIndex) {
				if (computedMinCosts[i][curHouseIndex+1] == 0) {
					computedMinCosts[i][curHouseIndex+1] = getMinPaintCost2(houseSizes, colorCosts, curHouseIndex+1, i, computedMinCosts); 
				}
				
				int newCost = houseSizes[curHouseIndex]*colorCosts[i] + computedMinCosts[i][curHouseIndex+1];
				
				if (minCost > newCost) {
					minCost = newCost;
				}
			}
		}
		
		return minCost;
	}
	
	// Solution 1: O(3^n) naive recursive solution
	public static int getMinPaintCost1(int[] houseSizes, int[] colorCosts, int curHouseIndex, int previousCostIndex) {
		if (curHouseIndex == houseSizes.length-1) {
			return Math.min(houseSizes[curHouseIndex]*colorCosts[(previousCostIndex+1)%3], houseSizes[curHouseIndex]*colorCosts[(previousCostIndex+2)%3]);
		}
		
		int minCost = Integer.MAX_VALUE;

		for (int i=0;i<2;i++) {
			if (i != previousCostIndex) {
				int newCost = houseSizes[curHouseIndex]*colorCosts[i] + getMinPaintCost1(houseSizes, colorCosts, curHouseIndex+1, i);
				if (minCost > newCost) {
					minCost = newCost;
				}
			}
		}
		
		return minCost;
	}
}
