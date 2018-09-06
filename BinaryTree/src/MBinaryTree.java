
public class MBinaryTree {
	
	/**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
	
	TreeNode root;
	
	public void addNode(int val) {
		
		TreeNode node = new TreeNode(val);
		
		if (root == null) {
			root = node;
			
			return;
		}
		
		TreeNode parent;
		
		parent = root;
		
		while (true) {
		
			if (val < parent.value) {
				if (parent.left != null) {
					parent = parent.left;
				} else  {
					parent.left = node;
					return;
				}
			} else {
				if (parent.right != null) {
					parent = parent.right;
				} else {
					parent.right = node;
					return;
				}
			}
		}
	}
	
	public void removeNode(int x) {
		/**
		 * If this node value is x.
		 *   If this node has right child -> right child becomes the new right child of this node's parent.
		 * 		If this node has left child -> right child becomes parent of left child.
		 */
		
		//TODO:Complete work in progress.
		
		TreeNode node = root;
		TreeNode parent = node;
		
	
		while(node != null) {
			
			if (x < node.value) {
				parent = node;
				node = node.left;
				
				continue;
			} else if (x > node.value){
				parent = node;
				node = node.right;
				continue;
			}
			
			if (x == node.value) {
				
			}
		}
		
		
		
	}
	
	
	public static void printInOrderNodeValue(TreeNode node) {
		if (node != null) {
			printInOrderNodeValue(node.left);
			System.out.println(node.value);
			printInOrderNodeValue(node.right);
		}
	}
	
	
	public void printInOrder() {
		TreeNode node;
		
		node = root;
		
		if (node == null) {
			System.out.println("Empty");
			return;
		}
		System.out.println("Tree nodes: ");
		printInOrderNodeValue(node);
		System.out.println("----------");
	}
	
	
	public static void main(String [] args) {
		MBinaryTree binaryTree = new MBinaryTree();
		binaryTree.addNode(1);
		binaryTree.addNode(3);
		binaryTree.addNode(5);
		binaryTree.addNode(2);
		binaryTree.addNode(6);
		
		binaryTree.printInOrder();
	}

}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) {
		this.value = x;
	}
}
