/*
 *
 * Implement a Queue datastructure, using an array
 * 
 * TODO 1: Avoid SuppressWarnings
 * TODO 2: Implement an interface
 *
 */

public class QueueFromArray {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>(5);
		try {
			queue.enQueue(1);
			queue.enQueue(2);
			queue.enQueue(3);
			queue.enQueue(4);
			queue.enQueue(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		queue.print();
		
		try {
			queue.enQueue(6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("First value is: "+queue.peek());
			queue.deQueue();
			queue.deQueue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		queue.print();
		
		try {
			queue.enQueue(6);
			queue.enQueue(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		queue.print();
	}
	
	public static class MyQueue<T> {
		private Object[] array;
		private int startIndex;
		private int endIndex;
		private boolean queueEmpty;
		private boolean queueFull;
		
		public MyQueue(int size) {
			array = new Object[size];
			startIndex = 0;
			endIndex = 0;
			queueEmpty = true;
			queueFull = false;
		}
		
		public void enQueue(T value) throws Exception {
			if (queueFull) {
				throw new Exception("Queue is full.");
			}
			
			array[endIndex] = value;
			
			endIndex = (endIndex+1)%array.length;
			queueEmpty = false;
			
			if (endIndex == startIndex) {
				queueFull = true;
			}
		}
		
		public T deQueue() throws Exception {
			if (queueEmpty) {
				throw new Exception("Queue is empty.");
			}
			
			@SuppressWarnings("unchecked")
			T value = (T)array[startIndex];
			
			startIndex = (startIndex+1)%array.length;
			queueFull = false;
			
			if (startIndex == endIndex) {
				queueEmpty = true;
			}
			
			return value;
		}
		
		public T peek() throws Exception {
			if (queueEmpty) {
				throw new Exception("Queue is empty.");
			}
			
			@SuppressWarnings("unchecked")
			T value = (T)array[startIndex];
			
			return value;
		}
		
		public void print() {
			if (queueEmpty) {
				System.out.println();
				return;
			}
			
			if (endIndex <= startIndex) {
				for (int i=startIndex;i<array.length;i++) {
					System.out.print(array[i]+" ");
				}
				for (int i=0;i<endIndex;i++) {
					System.out.print(array[i]+" ");
				}
				System.out.println();
			} else {
				for (int i=startIndex;i<endIndex;i++) {
					System.out.print(array[i]+" ");
				}
				System.out.println();
			}
		}
	}
}
