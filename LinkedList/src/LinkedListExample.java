import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
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
        if (root == null) {
            System.out.println("Empty list");
        }
        Node n = root;
        while(n != null){
            System.out.println(n.value);
            n = n.next;
        }
    }
}

class Node {
  int value;
  Node next;
    Node(int val) {
        this.value = val;
    }
}

public class LinkedListExample {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        MLinkedList list = new MLinkedList();
        for(int j=1; j<= 4; j++) {
             list.addNode(j);
        }
        list.printLinkedList();
    }
}