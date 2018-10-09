import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * @author mahesh
 * 
 * 1. Class BFS
 * 2. Class Vertex (Node, isVisited)
 * 3. Adjacency Matrix
 * 4. Queue 
 *
 *  A--------D-------E
 *  |         \     /
 *  |          \___/
 *  |	       /   \ 
 *  |         /     \ 
 *  B--------C       F
 */


public class BFS {
	
	public static void main(String args[]) {
		
		BFS bfs = new BFS();
		
		Graph graph = bfs.new Graph();
		
		graph.vertices.add(bfs.new Vertex('A'));
		graph.vertices.add(bfs.new Vertex('B'));
		graph.vertices.add(bfs.new Vertex('C'));
		graph.vertices.add(bfs.new Vertex('D'));
		graph.vertices.add(bfs.new Vertex('E'));
		graph.vertices.add(bfs.new Vertex('F'));
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		
		graph.bfsTraverse();
		
	}
	
	class Graph {
		
		public static final int  MAX_SIZE = 20;
		
		int adjMatrix[][] = new int[MAX_SIZE][MAX_SIZE];
		
		List<Vertex> vertices = new ArrayList<Vertex>();
		Queue<Vertex> verticesQ = new LinkedList<Vertex>();
		
		Graph() {
			
		}
		
		public void addEdge(int startIndex, int endIndex) {
			adjMatrix[startIndex][endIndex] = 1;
			adjMatrix[endIndex][startIndex] = 1;
		}
		
		public void bfsTraverse() {
			
			int index = 0;
			
			Vertex v = vertices.get(index);
			verticesQ.add(v);
			v.isVisited = true;
			
			System.out.println(v.label);
			
			while (!verticesQ.isEmpty()) {
				verticesQ.remove();
				while (getUnvisitedNeighbor(index) != null) {
					Vertex neighbor = getUnvisitedNeighbor(index);
					neighbor.isVisited = true;
					verticesQ.add(neighbor);
					System.out.println(neighbor.label);
				}
				
				index ++;
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
