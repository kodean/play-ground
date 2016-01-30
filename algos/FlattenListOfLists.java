import java.util.ArrayList;

/*
 * Given list of lists, flatten it.
 *
 * Input:
 * a -> b -> c -> d
 * |         |
 * e         h
 * |
 * f
 *
 * Output
 * a -> e -> f -> b -> c -> h -> d
 *
*/

import java.util.ArrayList;

public class FlattenListOfLists {
	public static void main(String[] args) {
		Node root = new Node("a", new Node("b", new Node("c",new Node("d",null,null),new Node("h",null,null)),null), new Node("e",null,new Node("f",null, null)));
	
		System.out.println("Lists, before flattening:");
		root.print();	

		flattenListOfLists(root);

		System.out.println("After flattening:");
		root.print();
	}
	
	public static class Node {
		public String data;
		public Node right, down;
		
		public Node(String data, Node right, Node down) {
			this.data = data;
			this.right = right;
			this.down = down;
		}

		// Print list of lists level by level
		public void print() {
			ArrayList<Node> curLevel = new ArrayList<Node>();
			Node node = this;
			while (node != null) {
				curLevel.add(node);
				node = node.right;
			}
			printLevel(curLevel);
		}

		private void printLevel(ArrayList<Node> nodes) {
			ArrayList<Node> nextLevel = new ArrayList<Node>();

                	boolean hasNextLevel = false;
                	for (Node node : nodes) {
                        	if (node == null) {
                                	System.out.print(" ");
                                	nextLevel.add(null);
                        	} else {
                                	System.out.print(node.data);
                                	nextLevel.add(node.down);
                                	hasNextLevel = true;
                        	}
                	}
                	System.out.println();

                	if (hasNextLevel) {
                        	printLevel(nextLevel);
                	}
		}
	}
	
	public static void flattenListOfLists(Node node) {
		while (node != null) {
			Node right = node.right;
			flattenList(node,right); 
			
			/*
			// Note that you can call flattenList method in parallel.
			final Node curNode = node;
			final Node rightNode = right;
			new Thread(new Runnable() { public void run() { flattenList(curNode,rightNode); } }).start();
			*/
			
			node = right;
		}
	}
	
	private static void flattenList(Node node, Node end) {
		while (node.down != null) {
			node.right = node.down;
			node.down = null;
			node = node.right;
		}
		
		node.right = end;
	}
}
