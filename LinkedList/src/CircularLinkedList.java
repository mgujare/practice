import java.util.HashSet;
import java.util.Set;

/**
 * @author mgujare
 *
 */
public class CircularLinkedList {

	static Set<Node> visitedNodes = new HashSet<Node>();

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node root = new Node(7);
		Node n1 = new Node(7);
		Node n2 = new Node(8);
		Node n3 = new Node(9);
		Node n4 = new Node(10);

		root.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;

		System.out.println("Is circular linked list " + isCircularLinkedListOptimal(root));
		
		System.out.println("Length of Loop in linked list " + findLengthOfLoop(root));
		

	}
	
	/**
	 * 
	 * @param n
	 * @return true if there is a loop in linkedlist with head as start and end node.
	 */

	public static boolean isCircularLinkedList(Node n) {

		Node head = n;

		while (n != null) {

			visitedNodes.add(n);

			n = n.next;

			if (visitedNodes.contains(n)) {
				if (head == n) {
					return true;
				} else {
					return false;
				}
			}

		}

		return false;
	}
	
	public static boolean isCircularLinkedListOptimal(Node n) {
		
		Node head = n;
		Node p1 = n;
		
		while(n != null) {
			n = n.next;
			
			if (p1.next != null) {
				p1 = p1.next.next;
			}
			
			if (head == n) {
				return true;
			}
			
			if (p1 == n) {
				System.out.println("Non head loop found");
				return false;
			}
			
		}
		
		return false;
	}
	
	public static int findLengthOfLoop(Node n) {
		
		Node head = n;
		Node p1 = n;
		int loopLength = 0;
		int loopTraversalCount = 0;
		
		while(n != null) {
			n = n.next;
			
			if (loopTraversalCount == 1) {
				loopLength++;
			}
			
			if (p1.next != null) {
				p1 = p1.next.next;
			}
			
			if (head == n) {
				++loopTraversalCount;
				
				if (loopTraversalCount == 2) {
					return loopLength;
				}
			}
			
			if (p1 == n) {
				++loopTraversalCount;
				System.out.println("Non head loop found");
				if (loopTraversalCount == 2) {
					return loopLength;
				}
			}
			
		}
		
		return 0;
	}

}
