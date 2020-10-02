
public class DutchFlagProblem {
	
	/**
	 * Dutch flag has 3 colors, hence the name.
	 * Problem Defn : Given a linked list with 3 distinct possible values, 
	 * sort the LinkedList such that nodes are ordered in value.
	 * 
	 * Eg : i/p = LinkedList with values {1, 0, 0, 2, 1, 1, 2, 2, 0, 1}
	 * 		o/p = LinkedList {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node n1 = new Node(0);
		Node n2 = new Node(0);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		Node n6 = new Node(2);
		Node n7 = new Node(2);
		Node n8 = new Node(0);
		Node n9 = new Node(1);
		
		root.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		
		//Other combo.
//		root.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
//		n6.next = n7;
//		n7.next = n9;
		
		System.out.println("LinkedList in original order.");
		prettyPrintList(root);
		Node n = dutchSortList(root);
		System.out.println(" \n LinkedList after DUTCH SORT.");
		prettyPrintList(n);
		
	}
	
	public static void prettyPrintList(Node n) {
		while (n != null) {
			System.out.print(" " + n.val + " ->");
			n = n.next;
		}
	}
	
	public static Node dutchSortList(Node n) {
		int[] nums = new int[3];// Use a map if distinct values are dynamic.
		Node original = n;
		
		//Traverse the linkedlist to populate the nums array with count of each distinct value.
		
		while (n != null) {
			
			if (n.val == 0) {
				++nums[0];
			} else if (n.val == 1) {
				++nums[1];
			} else if (n.val == 2) {
				++nums[2];
			}
			
			n = n.next;
			
		}
		
		// Now traverse the list again and 
		// update the original list with node val per count of each distinct val present.
		
		n = original;
		
		while (n != null) {

			if (nums[0] > 0) {
				n.val = 0;
				nums[0] = nums[0] - 1;
			} else if (nums[1] > 0) {
				n.val = 1;
				nums[1] = nums[1] - 1;
			} else if (nums[2] > 0) {
				n.val = 2;
				nums[2] = nums[2] - 1;
			}

			n = n.next;

		}
		
		return original;
		
	}

}
