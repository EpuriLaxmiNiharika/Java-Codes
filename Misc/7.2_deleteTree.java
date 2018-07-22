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

	void deleteTree(){

		/*
			// In Java automatic garbage collection
	        // happens, so we can simply make root
	        // null to delete the tree
	
		*/
		root = null;
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.deleteTree();
	}
}