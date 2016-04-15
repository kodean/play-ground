/*
 * Delete a given node from LinkedList.
 *
 * Note: This node can't be the tail node since we are only given access to this node (head is not given).
 */

public class LinkedListDeleteNode {
	public static void main(String[] args) {
		LinkedListNode<String> node3 = new LinkedListNode<String>("three", null);
		LinkedListNode<String> node2 = new LinkedListNode<String>("two", node3);
		LinkedListNode<String> node1 = new LinkedListNode<String>("one", node2);
		node1.print();

		deleteNode(node2);
		
		node1.print();

		deleteNode(node3);

		node1.print();
	}

	public static <T> void deleteNode(LinkedListNode<T> node) {
		if (node == null || node.next == null) {
			return;
		}

		node.data = node.next.data;
		node.next = node.next.next;
	} 

	public static class LinkedListNode<T> {
		T data;
		LinkedListNode<T> next;

		public LinkedListNode(T data, LinkedListNode<T> next) {
			this.data = data;
			this .next = next;
		}

		public void print() {
			System.out.print(data+" ");
			if (next != null) {
				next.print();
			} else {
				System.out.println();
			}
		}
	}
}
