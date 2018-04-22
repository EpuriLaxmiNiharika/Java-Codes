class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
		left = right = null;
	}
}


class BinaryTree{

	Node root;

	void reverseLevelOrder(Node root){

		int height = heightTree(root);

		for(int i = height; i>=0;i--){
			printLevelNodes(root,i);
			System.out.println("");
		}
	}


	void printLevelNodes(Node root, int level){

		if(root == null){
			return;
		}

		if(level==0){
			System.out.print(" "+root.value);
			return;
		}

		printLevelNodes(root.left,level-1);
		printLevelNodes(root.right,level-1);
	}

	int heightTree(Node node){

		if(node==null) return 0;

		int left = heightTree(node.left);

		int right = heightTree(node.right);

		if(left>right) return right+1;

		return left+1;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
  
        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
          
        System.out.println("Level Order traversal of binary tree is : ");
        tree.reverseLevelOrder(tree.root);
	}

}