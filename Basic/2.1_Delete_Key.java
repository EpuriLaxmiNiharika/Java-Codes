/*
	 When we delete a node, three possibilities arise. - node has 1 child, 2 child, no child(leaf)

*/

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class BST{

	Node root;

	Node insertNode(Node node, int value){

		if(node==null){

			return new Node(value);
		}
		
		if(node.value>value){
			node.left = insertNode(node.left,value);
		}
		else{
			node.right = insertNode(node.right,value);
		}

		return node;
	}

	void insert(int value){
		root = insertNode(root,value);
	}

	boolean isLeaf(Node n){


		if(n.left==null && n.right==null){
			return true;
		}
		return false;
	}

	Node deleteKey(Node node, int value){

		if(node==null){
			return null;
		}

		if(node.value<value){
			node.right =  deleteKey(node.right,value);
		}

		else if(node.value>value){
			node.left =  deleteKey(node.left,value);
		}

		else{ // node value is same as search node value

			if(node.left==null){
				return node.right;
			}

			else if(node.right==null){
				return node.left;
			}

				// find inorder sucessor or predecessor and delete that successor or predecessor node

			node.value = getMin_right(node.right);
	
			node.right = deleteKey(node.right,node.value);
		}

		return node;
	}

	int getMin_right(Node node){
		int min = node.value;

		while (node.left!=null) {
			min = node.left.value;
			node = node.left;
		}

		return min;
	}

	void inorderTraversal(Node node){

		if(node==null){

			return;
		}

		inorderTraversal(node.left);
		System.out.print(node.value+" ");
		inorderTraversal(node.right);
	}

	public static void main(String[] args) {
		
		BST bst = new BST();

		bst.insert(50);
    	bst.insert(30);
    	bst.insert(20);
    	bst.insert(40);
    	bst.insert(70);
    	bst.insert(60);
    	bst.insert(80);
		
		
		bst.inorderTraversal(bst.root);
		System.out.println();
		
		bst.deleteKey(bst.root,50);
	
		System.out.println();
		bst.inorderTraversal(bst.root);

	}
}