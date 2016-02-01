/*
 * Implement a Stack datastructure, using an array
 * 
 * TODO 1: Avoid SuppressWarnings
 * TODO 2: Implement an interface
 */

public class StackFromArray {
	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<Integer>(3);
		
		try {
			myStack.push(1);
			myStack.push(2);
			myStack.push(3);
			
			myStack.print();
			
			myStack.push(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Popped: "+myStack.pop());
			System.out.println("Top of stack: "+myStack.peek());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			myStack.pop();
			myStack.pop();
			myStack.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class MyStack<T> {
		private Object[] array; // You can't have T[]
		private int curIndex;
		
		public MyStack(int size) {
			array = new Object[size];
			curIndex = 0;
		}
		
		public void push(T value) throws Exception {
			if(curIndex >= array.length) {
				throw new Exception("Stack is full");
			}
			
			array[curIndex] = value;
			curIndex++;
		}
		
		@SuppressWarnings("unchecked")
		public T pop() throws Exception {
			if(curIndex == 0) {
				throw new Exception("Stack is empty");
			}
			
			curIndex--;
			
			return (T)array[curIndex];
		}
		
		@SuppressWarnings("unchecked")
		public T peek() throws Exception {
			if(curIndex == 0) {
				throw new Exception("Stack is empty");
			}
			
			return (T)array[curIndex-1];
		}
		
		public int size() {
			return curIndex;
		}
		
		public void print() {
			for (int i=0;i<curIndex;i++) {
				System.out.print(array[i]+" ");
			}
			System.out.println();
		}
	}
}
