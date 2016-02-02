/*
 * Given bunch of points, return the maximum number of points that are co-linear
 * 
 * For each point, check slopes of the lines from it to all other point. Note down
 * the maximum number of same slopes. Do this for all points.
 *
 * Be careful with vertical lines (infinite slope) and floating point errors.
 *
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

public class CountColinearPoints {
	public static void main(String[] args) {
		HashSet<Point> pointSet = new HashSet<Point>() {{
			add(new Point(1,1));
			add(new Point(0,1));
			add(new Point(2,1));
			add(new Point(1,3));
			add(new Point(2,2));
			add(new Point(3,3));
			add(new Point(5,5.0000001));
		}};
		
		System.out.println(getMaxColinearPoints(pointSet));
	}
	
	public static int getMaxColinearPoints(HashSet<Point> pointSet) {
		int maxColinear = 1;
		
		for (Point pt1 : pointSet) {
			HashMap<Double,Integer> slopeCounts = new HashMap<Double,Integer>();
			int verticals = 0; // Number of vertical lines
			
			for (Point pt2 : pointSet) {
				if (pt1 == pt2) {
					continue;
				}
				
				if (pt2.x == pt1.x) {
					verticals++;
				} else {
					double slope = Math.round((pt2.y-pt1.y)/(pt2.x-pt1.x)*100.0)/100.0; // Round off the double to 2 decimal places
					
					if (slopeCounts.containsKey(slope)) {
						slopeCounts.put(slope,slopeCounts.get(slope)+1);
					} else {
						slopeCounts.put(slope,1);
					}
				}
			}
		
			maxColinear = Math.max(maxColinear,Math.max(verticals,Collections.max(slopeCounts.values())));	
		}

		return maxColinear;
	}
	
	public static class Point {
		public double x, y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
