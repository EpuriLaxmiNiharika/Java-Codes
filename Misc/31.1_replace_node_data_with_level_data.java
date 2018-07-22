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

	void replaceNode(Node node, int depth){

		if(node==null){
			return;
		}

		node.value = depth;

		replaceNode(node.left,depth+1);
		replaceNode(node.right,depth+1);
	}

	void printInorder(Node node){
     	if (node == null)
          return;
     	printInorder(node.left);
    	System.out.print(node.value+" ");
 	    printInorder(node.right);
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 	
 		tree.printInorder(tree.root);
	    tree.replaceNode(tree.root,0);  

	    System.out.println("After Replacing Nodes\n");
	     
	    tree.printInorder(tree.root);
       
	}
}