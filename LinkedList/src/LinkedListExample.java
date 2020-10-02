import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
     * Definition for singly-linked list.
     * 
     */


    
class MLinkedList {
  Node root;
  Node prevNode;
  MLinkedList() {
      prevNode = root;   
  } 
    public void addNode(int val) {
        Node n = new Node(val);
        if (root == null) {
            root = n;
        } else {
            prevNode.next = n;
        }
        prevNode = n;
    }
    
    public void printLinkedList() {
    	System.out.println("List nodes: ");
        if (root == null) {
            System.out.println("Empty list");
        }
        Node n = root;
        while(n != null){
            System.out.print(n.val + ", ");
            n = n.next;
        }
        System.out.println("");
    }
    
    public boolean removeNode(int x) {
    	
    	if (root != null && root.val == x) {
    		root = root.next;
    		return true;
    	}
    	
    	Node n = root.next;
    	Node prev = root;
    	
    	while(n != null) {
    		
    		if (n.val == x) {
    			prev.next = n.next;
    			return true;
    		}
    		prev = n;
    		n = n.next;
    		
    	}
    	
    	
    	return false;
    }
}

public class LinkedListExample {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        MLinkedList list = new MLinkedList();
        
        for(int j=1; j<= 4; j++) { // Add nodes 1,2,3,4
             list.addNode(j);
        }
        list.printLinkedList();  // Print list nodes. {1,2,3,4}
        
        list.removeNode(3); //remove node 3
        
        list.printLinkedList();  // Print list nodes. {1,2,4}
    }
}