/*
 * Reverse a LinkedList
 */

public class LinkedListReverse {
	public static void main(String[] args) {
		Node head = new Node(1,new Node(2, new Node(3,null)));
		head.print();
		
		head = reverseLinkedList(head);
		head.print();
		
		head = reverseLinkedListRecursively(head, null);
		head.print();
	}
	
	private static Node reverseLinkedList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node previous = null;
		while (head!=null) {
			Node temp = head.next;
			head.next = previous;
			previous = head;
			
			head = temp;
		}
		
		return previous;
	}
	
	private static Node reverseLinkedListRecursively(Node head, Node previous) {
		if (head == null) {
			return previous;
		}
		
		Node temp = head.next;
		head.next = previous;
		
		return reverseLinkedListRecursively(temp,head);
	}
	
	public static class Node {
                int data;
                Node next;

                Node (int data, Node next) {
                        this.data = data;
                        this.next = next;
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
