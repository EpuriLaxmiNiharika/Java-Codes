

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}

	Node(){

	}

}


class BinaryTree{

	Node root;
	static Node prev = null;




	Node inorderTraverse(Node node){

		if(node==null){
			return null;
		}

		inorderTraverse(node.left);

		node.left = prev;
		prev = node;

		inorderTraverse(node.right);

		return node; // node is the root node of the tree

	}

	Node inorderTraverseRight(){

		inorderTraverse(root);
		Node  node  = root;
		while(node.right!=null){

			node = node.right;
		}

		while(node!=null && node.left!=null){

			Node leftNode = node.left;
			leftNode.right = node;

			node = node.left;
		}

		System.out.println();System.out.println();
		return node;
	}



	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        Node n = tree.inorderTraverseRight();
 		
 		Node temp = n;
 		while (temp!=null) {
 			System.out.print(temp.value+"  ");
 			temp = temp.right;
 		}
	}
}