class Node{

	String value;
	Node left;
	Node right;

	Node(String value){
		this.value = value;
		left = null;
		right = null;
	}	
}

class BinaryTree{

	Node root;

	int preorder;

	BinaryTree(){
		preorder = 0;
	}

	Node buildTree(String[] preOrderTraversal, String[] inOrderTraversal, int start, int end){


		if(start>end) return null;

	//	System.out.println("preorder "+preorder +" start: "+start +" end: "+end);

		Node root_node = new Node(preOrderTraversal[preorder]);
		preorder ++;

		if(start == end){
			return root_node;
		}



		int i = start; // i holds the root_node index in inorder traversal

		for(i = start; i<=end;i++){
			if(inOrderTraversal[i].equals(root_node.value)){
				break;
			}
		}


		root_node.left = buildTree(preOrderTraversal, inOrderTraversal, start, i -1);
		root_node.right = buildTree(preOrderTraversal,inOrderTraversal, i+1, end);

		return root_node;
	}


	void printInorder(Node root_node){

		if (root_node == null)
            return;
  
        /* first recur on left child */
        printInorder(root_node.left);
  
        /* then print the data of node */
        System.out.print(root_node.value + " ");
  
        /* now recur on right child */
        printInorder(root_node.right);

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
        String in[] = new String[]{"10", "4", "11", "2", "5", "8","1","6","3","9","7"};
        String pre[] = new String[]{"1", "2", "4", "10", "11", "5","8","3","6","7","9"};
        int len = in.length;
        Node root = tree.buildTree(pre,in, 0, len - 1);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
	}
}