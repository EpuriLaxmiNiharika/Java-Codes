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

		boolean leftChild = (n.left!=null) && (n.left.left==null && n.left.right==null); // checking if a node has left child and if left child is leafnode

		boolean rightChild = (n.right!=null) && (n.right.left==null && n.right.right==null);  // checking if a node has right child and if right child is leafnode

		if(leftChild && n.left.value==value){
				n.left = null;
				return;
		}

		else if(rightChild && n.right.value==value){
				n.right = null;
				return;
			}

		deleteLeafNode(n.left,value);
		deleteLeafNode(n.right,value);
	}

	static void inorder(Node n){

		if(n==null){
			return;
		}

		inorder(n.left);
		System.out.print(n.value+" ");
		inorder(n.right);
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.inorder(tree.root);
        System.out.println();
        tree.deleteLeafNode(tree.root,5);
        tree.inorder(tree.root);
	}
}