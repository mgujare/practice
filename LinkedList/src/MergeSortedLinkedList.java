
public class MergeSortedLinkedList {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Node ll1 = new Node(23);
		Node l1n1 = new Node(53);
		Node l1n2 = new Node(72);
		Node l1n3 = new Node(87);
		Node l1n4 = new Node(91);

		ll1.next = l1n1;
		l1n1.next = l1n2;
		l1n2.next = l1n3;
		l1n3.next = l1n4;


		Node ll2 = new Node(2);
		Node l2n1 = new Node(24);
		Node l2n2 = new Node(36);
		Node l2n3 = new Node(49);
		Node l2n4 = new Node(58);
		Node l2n5 = new Node(78);
		Node l2n6 = new Node(117);

		ll2.next = l2n1;
		l2n1.next = l2n2;
		l2n2.next = l2n3;
		l2n3.next = l2n4;
		l2n4.next = l2n5;
		l2n5.next = l2n6;

		System.out.println("Linked List One ");
		prettyPrintList(ll1);

		System.out.println("\n Linked List Two ");
		prettyPrintList(ll2);

		Node result = mergeSortedLinkedList(ll1, ll2);

		System.out.println("\n Linked List Merged ");
		prettyPrintList(result);

	}

	public static void prettyPrintList(Node n) {
		while (n != null) {
			System.out.print(" " + n.val + " ->");
			n = n.next;
		}
	}

	public static Node mergeSortedLinkedList(Node node1, Node node2) {

		if (node1 == null && node2 == null) return node1;

		if (node1 == null) return node2;

		if (node2 == null) return node1;

		Node head = null;

		Node current = (node1.val < node2.val) ? node1 : node2;

		head = current;

		if (current == node1) node1 = node1.next;

		if (current == node2) node2 = node2.next;

		while (node1 != null || node2 != null) {
			
			if (node1 == null) {
				current.next = node2;
				node2 = node2.next;
				current = current.next;
				continue;
			}
			
			if (node2 == null) {
				current.next = node1;
				node1 = node1.next;
				current = current.next;
				continue;
			}

			if (node1.val < node2.val) {
				current.next = node1;
				node1 = node1.next;
			} else {
				current.next = node2;
				node2 = node2.next;
			}

			current = current.next;
		}

		return head;

	}

	/**
	 *   Linked List One 
		 23 -> 53 -> 72 -> 87 -> 91 ->
		 Linked List Two 
		 2 -> 24 -> 36 -> 49 -> 58 -> 78 -> 117 ->
		 Linked List Merged 
		 2 -> 23 -> 24 -> 36 -> 49 -> 53 -> 58 -> 72 -> 78 -> 87 -> 91 -> 117 ->
	 * 
	 * 
	 * 
	 */

}
