/*
 * Find the start node of cycle in a circular LinkedList
 */

public class LinkedListCycleStart {
	public static void main(String[] args) {
		LinkedListNode lastNode = new LinkedListNode(14, null);
		LinkedListNode circular = new LinkedListNode(11, new LinkedListNode(12, new LinkedListNode(13, lastNode)));
		lastNode.next = circular;
		
		LinkedListNode head = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, circular)));
		
		head.print(10);
		System.out.println("Cycle starts at: "+cycleStartNode(head).data);
		
		circular.print(10);
		System.out.println("Cycle starts at: "+cycleStartNode(circular).data);
	}
	
	public static LinkedListNode cycleStartNode(LinkedListNode head) {
		LinkedListNode fastRunner = head;
		LinkedListNode slowRunner = head;
		
		while (true) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
			
			if (fastRunner == slowRunner) {
				break;
			}
		}
		
		LinkedListNode cycleStartNode = head;
		while (cycleStartNode != fastRunner) {
			cycleStartNode = cycleStartNode.next;
			fastRunner = fastRunner.next;
		}
		
		return cycleStartNode;
	}
	
	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;
		
		public LinkedListNode(int data, LinkedListNode next) {
			this.data = data;
			this.next = next;
		}

		public void print(int n) {
			LinkedListNode cur = this;
                	int count = 0;
                	while (cur != null) {
                        	System.out.print(cur.data+" ");
                        	cur = cur.next;

                        	if (count++ > n) { // stop after n steps, in case of circular list.
                                	break;
                        	}
                	}
                	System.out.println();
		}
	}
}
