/*
 * Given two nodes of a graph, check if there is a path between the two.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphRoute {
	public static void main(String[] args) {
		GraphNode<Integer> graphNode1 = new GraphNode<Integer>(1);
		GraphNode<Integer> graphNode2 = new GraphNode<Integer>(2);
		GraphNode<Integer> graphNode3 = new GraphNode<Integer>(3);
		GraphNode<Integer> graphNode4 = new GraphNode<Integer>(4);
		GraphNode<Integer> graphNode5 = new GraphNode<Integer>(5);
		
		graphNode1.addConnection(graphNode2);
		graphNode1.addConnection(graphNode3);
		graphNode3.addConnection(graphNode2);
		graphNode3.addConnection(graphNode4);
		graphNode2.addConnection(graphNode5);
		graphNode5.addConnection(graphNode4);
		
		System.out.println(hasRoute(graphNode1,graphNode2));
		System.out.println(hasRoute(graphNode2,graphNode1));
		System.out.println(hasRoute(graphNode1,graphNode4));
		System.out.println(hasRoute(graphNode5,graphNode3));
		System.out.println(hasRoute(graphNode1,graphNode1)); // returning true.
	}
	
	// Breadth-first
	public static <T> boolean hasRoute(GraphNode<T> start, GraphNode<T> end) {
		if (start == null) {
			return false;
		}
		
		HashSet<GraphNode<T>> alreadyVisited = new HashSet<GraphNode<T>>();
		
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			GraphNode<T> curNode = queue.poll();
			
			if (curNode == end) {
				return true;
			}
			
			if (alreadyVisited.contains(curNode)) {
				continue;
			} else {
				alreadyVisited.add(curNode);
			}
			
			if (curNode != null && curNode.connections != null) {
				queue.addAll(curNode.connections);
			}
		}
		
		return false;
	}
	
	public static class GraphNode<T> {
		public T data;
		public ArrayList<GraphNode<T>> connections;
		
		public GraphNode(T data) {
			this.data = data;
		}
		
		public void addConnection(GraphNode<T> connectionNode) {
			if (connections == null) {
				connections = new ArrayList<GraphNode<T>>();
			}
			connections.add(connectionNode);
		}
	}
}
