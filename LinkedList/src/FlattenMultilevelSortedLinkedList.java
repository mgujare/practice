
public class FlattenMultilevelSortedLinkedList {
	
	public static void main(String[] args) {
		
		MultiNode root = new MultiNode(2);
		MultiNode n1 = new MultiNode(15);
		MultiNode n2 = new MultiNode(17);
		
		MultiNode n3 = new MultiNode(5);
		MultiNode n4 = new MultiNode(25);
		MultiNode n5 = new MultiNode(33);
		
		MultiNode n6 = new MultiNode(18);
		MultiNode n7 = new MultiNode(54);
		MultiNode n8 = new MultiNode(77);
		
		MultiNode n9 = new MultiNode(43);
		MultiNode n10 = new MultiNode(66);
		MultiNode n11 = new MultiNode(68);
		
		root.next = n1;
		n1.next = n2;
		root.right = n3;
		
		n3.next = n4;
		n4.next = n5;
		n3.right = n6;
		
		n6.next = n7;
		n7.next = n8;
		n6.right = n9;
		
		n9.next = n10;
		n10.next = n11;
		
		
		MultiNode result = flattenLinkedList(root);
		prettyPrintList(result);
	}
	
	public static void prettyPrintList(MultiNode n) {
		while (n != null) {
			System.out.print(" " + n.val + " ->");
			n = n.next;
		}
	}

	
	public static MultiNode flattenLinkedList(MultiNode node) {
		if (node == null || node.right == null) {
			return node;
		} else {
			return mergeSortedLinkedList(node, flattenLinkedList(node.right));
		}
	}
	
	public static MultiNode mergeSortedLinkedList(MultiNode node1, MultiNode node2) {

		if (node1 == null && node2 == null) return node1;

		if (node1 == null) return node2;

		if (node2 == null) return node1;

		MultiNode head = null;

		MultiNode current = (node1.val < node2.val) ? node1 : node2;

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

}
