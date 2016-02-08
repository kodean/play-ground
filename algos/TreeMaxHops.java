/*
 * Return max of number of hops between any two nodes in a tree
 */

import java.util.Collections;
import java.util.HashSet;

public class TreeMaxHops {
	
	public static void main(String[] args) {
		// Build tree
		Node tree = new Node(2,
				     new Node(5,
					      new Node(0,
						       new Node(1,null,null),
						       new Node(2,
								new Node(3,null,null),
								null)),
					      new Node(-1,
						       new Node(1,
								null,
								new Node(6,null,null)),
						       null)),
				     new Node(1,
					      new Node(4,null,null),
					      new Node(3,null,null)));
		
		System.out.println(getMaxHops(tree));
	}
	
	// Use an object (in this case, an int array) to store the maximum number of hops so far.
	// Note that we can't just use Integer as the object to keep track of max number of hops since
	// Integer is immutable. We need to use a mutable object.
	public static int getMaxHops(Node tree) {
		int[] maxHops = new int[1];
		getDepth(tree,maxHops);
		
		return maxHops[0];
	}

	// Recursively get depth and also keep track of max hops	
	public static int getDepth(Node node, int[] maxHops) {
		if (node == null) {
			return 0;
		}
		
		int leftDepth = getDepth(node.left,maxHops);
		int rightDepth = getDepth(node.right,maxHops);
		
		int hops = leftDepth+rightDepth;
		if (hops > maxHops[0]) {
			maxHops[0] = hops;
		}
		
		return 1+Math.max(leftDepth, rightDepth);
	}
	
	// Iteratively get depth and also keep track of max hops

	public static class Node {
		public int data;
		public Node left, right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
