//https://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/

// THIS APPROACH MODIFies THE EXISTING BINARY TREE

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}


class BinaryTree{

	Node root;

	static Node prev = null;

	void populateLeft(Node node){

		if(node==null){
			return;
		}

		populateLeft(node.left);

		node.left = prev;
		prev = node;

		populateLeft(node.right);
	}

	Node populateRight(Node node){ // points to rightmost node in the right subtree of "node"

		while(node!=null && node.right!=null){
			node = node.right;
		}

		while(node!=null && node.left!=null){

			Node leftNode = node.left;
			leftNode.right = node;
			node = leftNode;
		}

		return node;
	}


	Node convertDoublyLinkedList(){

		populateLeft(root);
		return populateRight(root);
	}


	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        Node node = tree.convertDoublyLinkedList();
 	

 		Node temp = node;

 		while (temp!=null) {
 			System.out.print(temp.value+"  ");
 			temp = temp.right;
 		}
	}
}