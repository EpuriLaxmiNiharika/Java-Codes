// THIS CODE AUTOMATICALLY ASSUMES THAT VALUES GIVEN ARE LEAF NODES

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

	void deleteLeafNode(Node n, int value){

		if(n==null){
			return;
		}

		if(n.left!=null && n.left.value==value){
			n.left = null;
			return;
		}

		else if(n.right!= null && n.right.value==value){
			n.right = null;
			return;
		}

		deleteLeafNode(n.left,value);
		deleteLeafNode(n.right,value);
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.deleteLeafNode(tree.root,5);
	}
}