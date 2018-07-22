class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
		left = null;
		right = null;
	}	
}

class BinaryTree{

	Node root;

	static int preorder_index = 0;

	Node buildTree(int[] preorder, int[] postorder, int start, int end){

		if(start>end ){
			return null;
		}

		if(preorder_index>=preorder.length){
			return null;
		}

		Node root_node = new Node(preorder[preorder_index]);
		preorder_index++;

		if(preorder_index>=preorder.length || start==end){

			return root_node;
		}

		int index = start;

		for( index = start;index<=end;index++){

			if(postorder[index]==preorder[preorder_index]){ // search for left subtree indices
				break;
			}
		}

	
		if(index<=end){
			// System.out.println(root_node.value+"---"+postorder[index] +" ---- "+start+"---"+index+"---"+end);
			root_node.left = buildTree(preorder,postorder,start,index);
			root_node.right = buildTree(preorder,postorder,index+1,end); // (...., end-1) will also work coz end holds the root node value. so ignore that
		}
		return root_node;
	}


	void printInorder(Node root_node){

		if (root_node == null)
            return;
  
        /* first recur on left child */


         System.out.print(root_node.value + " ");

        printInorder(root_node.left);
        printInorder(root_node.right);

  
        /* then print the data of node */
  		
        /* now recur on right child */
                        

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
       int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
    	int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        Node root = tree.buildTree(pre,post, 0, pre.length - 1);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
	}
}