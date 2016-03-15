/*
 * Check if a LinkedList is merged.
 * 
 */

public class LinkedListIsMerged {
	public static void main(String[] args) {
		LinkedListNode commonList = new LinkedListNode(4, new LinkedListNode(5, new LinkedListNode(6, null)));
		LinkedListNode firstList = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, commonList)));
		LinkedListNode secondList = new LinkedListNode(11, new LinkedListNode(12, commonList));
		LinkedListNode thirdList = new LinkedListNode(21, new LinkedListNode(22, new LinkedListNode(23, new LinkedListNode(24, null))));
		
		firstList.print();
		secondList.print();
		System.out.println(merged(firstList,secondList));
		
		firstList.print();
		thirdList.print();
		System.out.println(merged(firstList,thirdList));
	}
	
	public static boolean merged(LinkedListNode first, LinkedListNode second) {
		int lengthDifference = 0;
		
		LinkedListNode cur1 = first;
		LinkedListNode cur2 = second;
		
		while (cur1 != null && cur2 != null) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		
		LinkedListNode longerList, shorterList;
		
		if (cur1 == null) {
			longerList = second;
			shorterList = first;
			
			while (cur2 != null) {
				cur2 = cur2.next;
				lengthDifference++;
			}
		} else {
			longerList = first;
			shorterList = second;
			
			while (cur1 != null) {
				cur1 = cur1.next;
				lengthDifference++;
			}
		}
		
		for (int i=0;i<lengthDifference;i++) {
			longerList = longerList.next;
		}
		
		while (longerList != null && shorterList != null) {
			if (longerList == shorterList) {
				return true;
			}
			
			longerList = longerList.next;
			shorterList = shorterList.next;
		}
		
		return false;
	}
	
	public static void printList(LinkedListNode head) {
		LinkedListNode cur = head;
		while (cur != null) {
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static class LinkedListNode {
		public int data;
		public LinkedListNode next;
		
		public LinkedListNode(int data, LinkedListNode next) {
			this.data = data;
			this.next = next;
		}

		public void print() {
			LinkedListNode cur = this;
			while (cur != null) {
                        	System.out.print(cur.data+" ");
                        	cur = cur.next;
                	}
                	System.out.println();
		}
	}
}
