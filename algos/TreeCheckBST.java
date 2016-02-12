/*
 * Check if a Binary Tree is Binary Search Tree
 *
 */

import java.util.Stack;

public class TreeCheckBST {
	public static void main(String[] args) {
		TreeNode<Integer> tree1 = new TreeNode<Integer>(1,
								new TreeNode<Integer>(2,
										      new TreeNode<Integer>(4,null,null),
										      new TreeNode<Integer>(5,new TreeNode<Integer>(7,null,null),null)),
								new TreeNode<Integer>(3,new TreeNode<Integer>(6,null,null),null));

		TreeNode<Integer> tree2 = new TreeNode<Integer>(10,
								new TreeNode<Integer>(5,
										      new TreeNode<Integer>(4,null,null),
										      new TreeNode<Integer>(9,new TreeNode<Integer>(7,null,null),null)),
								new TreeNode<Integer>(15,new TreeNode<Integer>(12,null,null),null));
		
		System.out.println(isBSTrecursive(tree1,null,null));
		System.out.println(isBSTrecursive(tree2,null,null));
		
		System.out.println(isBSTiterative(tree1));
		System.out.println(isBSTiterative(tree2));
	}
	
	// recursive
	public static boolean isBSTrecursive(TreeNode<Integer> tree, Integer min, Integer max) {
		if (tree == null) {
			return true;
		}
		if (min != null && tree.data <= min) {
			return false;
		}
		if (max != null && tree.data > max) {
			return false;
		}
		
		return isBSTrecursive(tree.left,min,tree.data)&&isBSTrecursive(tree.right,tree.data,max);
	}
	
	// iterative
	public static boolean isBSTiterative(TreeNode<Integer> tree) {
		Stack<StackTreeNode> stack = new Stack<StackTreeNode>();
		stack.push(new StackTreeNode(tree,null,null));
		
		while (!stack.isEmpty()) {
			StackTreeNode curNode = stack.pop();
			
			if (curNode.node == null) {
				continue;
			}
			
			if (curNode.min != null && curNode.node.data <= curNode.min) {
				return false;
			}
			if (curNode.max != null && curNode.node.data > curNode.max) {
				return false;
			}
			
			stack.push(new StackTreeNode(curNode.node.left,curNode.min,curNode.node.data));
			stack.push(new StackTreeNode(curNode.node.right,curNode.node.data,curNode.max));
		}
		
		return true;
	}
	
	public static class StackTreeNode {
		public TreeNode<Integer> node;
		public Integer min, max;
		
		public StackTreeNode(TreeNode<Integer> node, Integer min, Integer max) {
			this.node = node;
			this.min = min;
			this.max = max;
		}
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
