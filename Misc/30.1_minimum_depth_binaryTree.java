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

	int minDepth(Node node){

		if(node==null){
			return 0;
		}

		int left = minDepth(node.left);
		int right = minDepth(node.right);

		return 1 + Math.min(left,right);
	}

	public static void main(String[] args) {
		
		 BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The minimum depth of "+
          "binary tree is : " + tree.minDepth(tree.root));
	}
}