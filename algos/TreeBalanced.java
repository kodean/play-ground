/*
 * Given a tree, check if it is balanced or not.
 *
 * If difference between minimum and maximum depths of the tree
 * don't differ by more than 1, you can consider the tree to be balanced.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeBalanced {
	public static void main(String[] args) {
		TreeNode<Integer> tree1 = new TreeNode<Integer>(1,
								new TreeNode<Integer>(2,
										      new TreeNode<Integer>(4,null,null),
										      new TreeNode<Integer>(5,null,null)),
								new TreeNode<Integer>(3,
										      new TreeNode<Integer>(6,null,null),
										      null));

		System.out.println(isBalancedRecursive(tree1)+" "+isBalancedBreadthFirst(tree1)+" "+isBalancedDepthFirst(tree1));
		
		TreeNode<Integer> tree2 = new TreeNode<Integer>(1,
								new TreeNode<Integer>(2,
										      new TreeNode<Integer>(4,
													    new TreeNode<Integer>(6,null,null),
													    null),
										      new TreeNode<Integer>(5,null,null)),
								new TreeNode<Integer>(3,null,null));

		System.out.println(isBalancedRecursive(tree2)+" "+isBalancedBreadthFirst(tree2)+" "+isBalancedDepthFirst(tree2));
	}
	
	// Recursive
	public static <T> boolean isBalancedRecursive(TreeNode<T> root) {
		return (getMaxDepth(root)-getMinDepth(root) <= 1);
	}
	
	private static <T> int getMinDepth(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1+Math.min(getMinDepth(root.left), getMinDepth(root.right));
	}
	
	private static <T> int getMaxDepth(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1+Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
	}
	
	// Iterative, breadth-first (level tracking similar to printing tree level by level).
	// Whenever we change level, increment max and min depths. When you encounter a leaf 
	// node, stop incrementing min depth.
	public static <T> boolean isBalancedBreadthFirst(TreeNode<T> root) {
		if (root == null) {
			return true;
		}
		
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(root);
		queue.add(null);
		
		boolean foundMinDepth = false;
		int minDepth = 0, maxDepth = 0;
		while (!queue.isEmpty()) {
			TreeNode<T> curNode = queue.poll();
			
			if (curNode == null && !queue.isEmpty()) {
				queue.add(null);
				maxDepth++;
				if (!foundMinDepth) {
					minDepth++;
				}
			} else if (curNode != null) {
				if (!foundMinDepth && curNode.left == null && curNode.right == null) {
					foundMinDepth = true;
				}
				if(curNode.left != null) {
					queue.add(curNode.left);
				}
				if(curNode.right != null) {
					queue.add(curNode.right);
				}
			}
		}

		return ((maxDepth-minDepth)<=1);
	}
	
	// Iterative, depth-first
	public static <T> boolean isBalancedDepthFirst(TreeNode<T> root) {
		if (root == null) {
			return true;
		}
		
		int minDistance = Integer.MAX_VALUE, maxDistance = Integer.MIN_VALUE;
		
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		Stack<Integer> levels = new Stack<Integer>();
		stack.push(root);
		levels.push(1);
		
		while (!stack.isEmpty()) {
			TreeNode<T> curNode = stack.pop();
			int curLevel = levels.pop();
			
			if (curNode.left == null && curNode.right == null) {
				minDistance = Math.min(minDistance, curLevel);
				maxDistance = Math.max(maxDistance, curLevel);
				
				if ((maxDistance-minDistance) > 1) {
					return false;
				}
			}
			if (curNode.left != null) {
				stack.push(curNode.left);
				levels.push(curLevel+1);
			}
			if (curNode.right != null) {
				stack.push(curNode.right);
				levels.push(curLevel+1);
			}
		}
		
		return true;
	}
	
	public static class TreeNode<T> {
		public T data;
		public TreeNode<T> left, right;
		
		public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
