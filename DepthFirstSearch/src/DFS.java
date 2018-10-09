import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * 
 * @author mahesh
 * 
 * 1. Class DFS
 * 2. Class Vertex (Node, isVisited)
 * 3. Adjacency Matrix
 * 4. Stack 
 *
 *  A--------D-------E
 *  |         \     /
 *  |          \___/
 *  |	       /   \ 
 *  |         /     \ 
 *  B--------C       F
 */


public class DFS {
	
	public static void main(String args[]) {
		
		DFS dfs = new DFS();
		
		Graph graph = dfs.new Graph();
		
		graph.vertices.add(dfs.new Vertex('A'));
		graph.vertices.add(dfs.new Vertex('B'));
		graph.vertices.add(dfs.new Vertex('C'));
		graph.vertices.add(dfs.new Vertex('D'));
		graph.vertices.add(dfs.new Vertex('E'));
		graph.vertices.add(dfs.new Vertex('F'));
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		graph.dfsTraverse();
		
	}
	
	class Graph {
		
		public static final int  MAX_SIZE = 20;
		
		int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
		
		List<Vertex> vertices = new ArrayList<Vertex>();
		Stack<Vertex> verticesStack = new Stack<Vertex>();
		
		Graph() {
			
		}
		
		public void addEdge(int startIndex, int endIndex) {
			adjMatrix[startIndex][endIndex] = 1;
			adjMatrix[endIndex][startIndex] = 1;
		}
		
		public void dfsTraverse() {
			
			int index = 0;
			
			Vertex v = vertices.get(index);
			verticesStack.add(v);
			v.isVisited = true;
			
			System.out.println(v.label);
			
			while (!verticesStack.isEmpty()) {
				Vertex v1 = verticesStack.peek();
				index = vertices.indexOf(v1);
				Vertex neighbor = getUnvisitedNeighbor(index);
				if (neighbor != null) {
					neighbor.isVisited = true;
					verticesStack.add(neighbor);
					System.out.println(neighbor.label);
				} else {
					verticesStack.pop();
				}
			}
			
		}
		
		public Vertex getUnvisitedNeighbor(int index) {
			
			for (int m = 0; m < vertices.size(); m ++) {
				
				if (adjMatrix[index][m] == 1) {
					Vertex neighbor = vertices.get(m);
					if (!neighbor.isVisited) {
						return neighbor;
					}
				}
				
			}
			return null;
		}
	}
	
	class Vertex {
		char label;
		boolean isVisited;
		
		Vertex(char label) {
			this.label = label;
		}
	}

}
