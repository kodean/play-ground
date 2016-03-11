/*
 * Given a sorted array, build a BST of minimum depth.
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class TreeFromArray {
	public static void main(String[] args) {
		int[] sortedArray1 = new int[] {1, 2, 3, 4, 5};
		convertSortedArrayToBST1(sortedArray1,0,sortedArray1.length-1).print();
		
		int[] sortedArray2 = new int[] {1, 2, 3, 4, 5, 6};
		convertSortedArrayToBST1(sortedArray2,0,sortedArray2.length-1).print();
	}
	
	// Recursive
	public static BSTNode convertSortedArrayToBST1(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = (start+end)/2;
		
		int value = array[mid];
		BSTNode binaryTreeNode = new BSTNode(value);
		binaryTreeNode.left = convertSortedArrayToBST1(array,start,mid-1);
		binaryTreeNode.right = convertSortedArrayToBST1(array,mid+1,end);
		
		return binaryTreeNode;
	}
	
	// Iterative, work on it!
	public static BSTNode convertSortedArrayToBST2(int[] array, int start, int end) {
		return null;
	}
	
	public static class BSTNode {
		public int data;
		public BSTNode left;
		public BSTNode right;
		
		public BSTNode(int data) {
			this.data = data;
		}
		
		public void print() {
			Queue<BSTNode> queue = new LinkedList<BSTNode>();
			queue.add(this);
			queue.add(null);
			
			while (!queue.isEmpty()) {
				BSTNode curNode = queue.poll();
				
				if (curNode == null && !queue.isEmpty()) {
					System.out.println();
					queue.add(null);
				} else if (curNode != null) {
					System.out.print(curNode.data+" ");
					if(curNode.left != null) {
						queue.add(curNode.left);
					}
					if(curNode.right != null) {
						queue.add(curNode.right);
					}
				}
			}
			System.out.println();
		}
	}
}
