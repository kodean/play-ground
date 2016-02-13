/*
 * Traverse a Binary Tree.
 */

import java.util.HashSet;
import java.util.Stack;

public class TreeTraversal {
	public static void main(String[] args) {
		TreeNode<Integer> tree1 = new TreeNode<Integer>(1,
								new TreeNode<Integer>(2,new TreeNode<Integer>(4,null,null),new TreeNode<Integer>(5,null,null)),
								new TreeNode<Integer>(3,new TreeNode<Integer>(6,null,null),null));
		
		// Recursive
		inOrderTraversal(tree1);
		System.out.println();
		preOrderTraversal(tree1);
		System.out.println();
		postOrderTraversal(tree1);
		System.out.println();		

		// Iterative
		iterativeInOrder(tree1);
		iterativePreOrder(tree1);
		iterativePostOrder(tree1);
	}
	
	public static void iterativeInOrder(TreeNode<Integer> node) {
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.pop();
				System.out.print(node.data+" ");
				node = node.right;
			} else {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	
	public static void iterativePreOrder(TreeNode<Integer> node) {
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.pop();
				node = node.right;
			} else {
				System.out.print(node.data+" ");
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}

	public static void iterativePostOrder(TreeNode<Integer> node) {
		HashSet<TreeNode<Integer>> visited = new HashSet<TreeNode<Integer>>();
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		while (!stack.isEmpty() || node != null) {
			if (node == null) {
				node = stack.peek();
				if (node.right == null || visited.contains(node.right)) {
					System.out.print(node.data+" ");
					visited.add(node);
					stack.pop();
					node = null;
				} else {
					node = node.right;
				}
				
			} else {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	
	public static void inOrderTraversal(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
	}
	
	public static void preOrderTraversal(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.data+" ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public static void postOrderTraversal(TreeNode<Integer> node) {
		if (node == null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data+" ");
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
