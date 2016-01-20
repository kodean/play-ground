/*
 * A Binary Search Tree was constructed by reading elements from an array (starting from index 0, to the end).
 * Given this BST, print all the possible arrays it was constructed from.
 * 
 * Notes:
 * 1. Main idea is that each node always appears in the array after it's parent node.
 *    So, the first element in the array would be root. 
 * 2. Nodes at the same level can appear in any order. So, we would need to get all possible orders.
 * 
 * Strategy:
 * Get possible arrays for left sub-tree and right sub-tree. Merge them in all possible combinations, making
 * sure that they don't violate the note #1 above. Prepend root to these combinations. 
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBSTArrays {
	public static void main(String[] args) {
		BinaryNode bstNode = new BinaryNode(10,new BinaryNode(5,null,new BinaryNode(8,null,null)),new BinaryNode(15,null,null));
		
		System.out.println(getPossibleLists(bstNode));
	}
	
	public static ArrayList<ArrayList<Integer>> getPossibleLists(BinaryNode root) {
		ArrayList<ArrayList<Integer>> possibleLists = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			possibleLists.add(new ArrayList<Integer>());
			return possibleLists;
		}
		if (root.left == null && root.right == null) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(root.data);
			possibleLists.add(newList);
			return possibleLists;
		} else if (root.left == null) {
			ArrayList<ArrayList<Integer>> rightSubLists = getPossibleLists(root.right);
			
			for (ArrayList<Integer> allSubList : rightSubLists) {
				ArrayList<Integer> newList = new ArrayList<Integer>(allSubList);
				newList.add(0, root.data);
				possibleLists.add(newList);
			}
			return possibleLists;
		} else if (root.right == null) {
			ArrayList<ArrayList<Integer>> leftSubLists = getPossibleLists(root.left);
			
			for (ArrayList<Integer> allSubList : leftSubLists) {
				ArrayList<Integer> newList = new ArrayList<Integer>(allSubList);
				newList.add(0, root.data);
				possibleLists.add(newList);
			}
			return possibleLists;
		}
		
		ArrayList<ArrayList<Integer>> leftSubLists = getPossibleLists(root.left);
		ArrayList<ArrayList<Integer>> rightSubLists = getPossibleLists(root.right);
		
		for (ArrayList<Integer> leftSubList : leftSubLists) {
			for (ArrayList<Integer> rightSubList : rightSubLists) {
				ArrayList<ArrayList<Integer>> allSubLists = mergeLists(leftSubList,rightSubList);
				
				for (ArrayList<Integer> allSubList : allSubLists) {
					ArrayList<Integer> newList = new ArrayList<Integer>(allSubList);
					newList.add(0, root.data);
					possibleLists.add(newList);
				}
			}
		}
		
		return possibleLists;
	}
	
	// Merge lists in all possible combinations preserving the order of individual lists
	// Eg: {1,2} and {3,4} should return {1,2,3,4},{1,3,2,4},{1,3,4,2},{3,1,2,4},{3,1,4,2} and {3,4,1,2}.
	// Note that 1 always comes before 2 in all lists above and similarly, 3 always comes before 4.
	public static ArrayList<ArrayList<Integer>> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<ArrayList<Integer>> mergedLists = new ArrayList<ArrayList<Integer>>();
		
		if (list1.size() == 0 && list2.size() == 0) {
			mergedLists.add(new ArrayList<Integer>());
		} else if (list1.size() == 0) {
			mergedLists.add(list2);
		} else if (list2.size() == 0) {
			mergedLists.add(list1);
		} else {
			if (list2.size() == 1) {
				for (int i=0;i<=list1.size();i++) {
					ArrayList<Integer> newList = new ArrayList<Integer>(list1);
					newList.add(i, list2.get(0));
					mergedLists.add(newList);
				}
			} else {
				int firstElement = list2.get(0);
				
				for (int i=0;i<=list1.size();i++) {
					ArrayList<ArrayList<Integer>> subMergedLists = mergeLists(new ArrayList<Integer>(list1.subList(i, list1.size())),
												  new ArrayList<Integer>(list2.subList(1, list2.size())));
					
					for (ArrayList<Integer> subMergedList : subMergedLists) {
						ArrayList<Integer> newList = new ArrayList<Integer>();
						newList.addAll(list1.subList(0, i));
						newList.add(firstElement);
						newList.addAll(subMergedList);
						mergedLists.add(newList);
					}
				}
			}
		}
		
		return mergedLists;
	}
	
	public static class BinaryNode {
		int data;
		BinaryNode left, right;
		
		public BinaryNode(int data, BinaryNode left, BinaryNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
