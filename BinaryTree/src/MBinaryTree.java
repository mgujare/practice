
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
	

		//TODO:Complete work in progress.

	public boolean removeNode(int x) {
		/**
		 * If this node value is x. Let's say this node has a parent.
		 *   If this node has right child -> right child becomes the new right child of this node's parent.
		 * 		If this node has left child -> this node's right child becomes parent of this node's left child.
		 */
		
		//TODO:Test progress.
		TreeNode node = root;
		TreeNode parent = node;
		
		//Root null
		if (node == null) {
			return false;
		}
		
		//Root has the target value and no children.
		if (node != null && node.left == null && node.right == null && node.value == x) {
			node = null;
			return true;
		}
		
		//Target is possibly down the tree leaves so we traverse the tree.
		
		while(node != null) {
			
			boolean isRightNode = false;
			boolean isLeftNode = false;
			
			if (x < node.value) {
				parent = node;
				node = node.left;
				isLeftNode = true;
				
			} else if (x > node.value) {
				parent = node;
				node = node.right;
				isRightNode = true;
			}
			
			//Next traversal is null.
			if (node == null) {
				return false;
			}
			
			//Target value matches the node value.
			if (x == node.value) {
				
				if (isRightNode) {
					parent.right = findReplacementNode(node);
					return true;
				}
				
				if (isLeftNode) {
					parent.left = findReplacementNode(node);
					return true;
				}
				
				// Node has target value and it's neither left nor right. Its' a root.
				//TODO:Complete this later.
			}
			
			continue;
		}
		
		
		return false;
	}
	
	public TreeNode findReplacementNode(TreeNode n) {
		
		System.out.println("Finding replacement for " + n.value);
		
		// At every node 4 cases.
		
		TreeNode replacementNode;
		
		if (n.right == null && n.left == null) {
			replacementNode = null;
		} else if (n.right != null && n.left == null) {
			replacementNode = n.right;
		}  else if (n.right == null && n.left != null) {
			replacementNode = n.left;
		} else { //(n.right != null && n.left != null)
			replacementNode = n.right;
			replacementNode.left = n.left;
		}
		
//		if (replacementNode == null) {
//			System.out.println("Returning null for " + n.value);
//		} else {
//			System.out.println("Returning " + replacementNode.value + " to replace " + n.value);
//		}
		
		return replacementNode;
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
//		binaryTree.addNode(1);
//		binaryTree.addNode(3);
//		binaryTree.addNode(5);
//		binaryTree.addNode(2);
//		binaryTree.addNode(6);
//		
//		binaryTree.printInOrder();
		
		
		//Empty tree:
		binaryTree = null;
		//Start fresh
		binaryTree = new MBinaryTree();
		
		//Adding nodes.
		binaryTree.addNode(4);
		binaryTree.addNode(3);
		binaryTree.addNode(10);
		binaryTree.addNode(20);
		binaryTree.addNode(15);
		binaryTree.addNode(13);
		binaryTree.addNode(17);
		binaryTree.addNode(14);
		binaryTree.addNode(8);
		//binaryTree.addNode(6);
		
		binaryTree.printInOrder();
		//Remove a node in the deep tree.
		binaryTree.removeNode(15);
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}
