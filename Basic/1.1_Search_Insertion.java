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

	boolean searchNode(Node node, int value){

		if(node==null){
			return  false;
		}

		if(node.value==value){
			return true;
		}

		if(node.value>value){
			return searchNode(node.left,value);
		}
		else{
			return searchNode(node.right,value);
		}
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

		bst.root = bst.insertNode(bst.root, 50);
		bst.root =bst.insertNode(bst.root,30);
		bst.root =bst.insertNode(bst.root,20);
		bst.root =bst.insertNode(bst.root,40);
		bst.root =bst.insertNode(bst.root,70);
		bst.root =bst.insertNode(bst.root,60);
		bst.root =bst.insertNode(bst.root,80);
		
		bst.inorderTraversal(bst.root);

		if(bst.searchNode(bst.root,80)){
			System.out.println("\npresent");
		}	
		else{
			System.out.println("\nNOT present");
		}
		
	}
}