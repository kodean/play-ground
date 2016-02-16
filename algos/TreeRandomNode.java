/*
 * Given a binary tree, return a random node with uniform probability
 * 
 * Solution 1: 
 *   Keep track of size of the tree. Get a random number from [0, N), say r.
 *   return r'th node of the tree in in-order traversal. 
 * 
 * Solution 2: 
 *   Keep track of size (number of nodes) of left and right subtrees at each node.
 *   (Or use order statistic tree).
 *   Get a random number from [0, N), say r. Traverse the tree using the size info of 
 *   each node, to figure out whether to go left or right.
 * 
 * Solution 3:
 *   Just maintain the nodes in an array as well and return array[r].
 * 
 * Solution 1: O(r) in time and O(1) in space
 * Solution 2: O(log r) in time and O(N) in space.
 * Solution 3: O(1) in time and O(N) in space.
 *
 */

import java.util.Random;

public class TreeRandomNode {
	public static void main(String[] args) {
		BinaryTreeNode tree = new BinaryTreeNode(5,
							 new BinaryTreeNode(3,
									    new BinaryTreeNode(1,null,null),
									    new BinaryTreeNode(4,null,null)),
							 new BinaryTreeNode(7,
									    new BinaryTreeNode(6,null,null),
									    new BinaryTreeNode(9,null,null)));
		
		for (int i=0;i<15;i++) {
			System.out.println(randomNode2(tree,7).data);
		}
	}
	
	// TODO: Solution 1 (in-order traversal, iterative)
	
	
	// Solution 1 (in-order traversal, recursive)
	public static BinaryTreeNode randomNode2(BinaryTreeNode root, int size) {
		int randomNumber = (new Random()).nextInt(size);
		
		BinaryTreeNode[] randomNodes = new BinaryTreeNode[1];
		inOrderTraversal2(root,randomNodes,0,randomNumber);
		
		return randomNodes[0];
	}
	
	public static int inOrderTraversal2(BinaryTreeNode root, BinaryTreeNode[] target, int count, int targetCount) {
		if (root == null) {
			return count;
		}
		if (count < 0) {
			return -1;
		}
		
		count = inOrderTraversal2(root.left,target,count,targetCount);
		
		if (count < 0) {
			return -1;
		} else if (count == targetCount) {
			target[0] = root;
			return -1;
		}
		
		return inOrderTraversal2(root.right,target,count+1,targetCount);
	}

	// TODO: Solution 3 (order statistic tree)
	
	public static class BinaryTreeNode {
		public int data;
		public BinaryTreeNode left;
		public BinaryTreeNode right;
		
		public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
