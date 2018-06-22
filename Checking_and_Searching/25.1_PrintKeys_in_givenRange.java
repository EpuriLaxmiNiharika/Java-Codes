// OUTPUT INCREASING ORDER OF KEYS DOENT GUARENTEE... 

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


	void printKeys_Range(Node n, int left, int right){

		if(n==null){
			return;
		}


		if(n.value>=left && n.value <=right){
			System.out.println(n.value);
			printKeys_Range(n.left,left,right);
			printKeys_Range(n.right,left,right);
		}

		if(n.value<left){
			printKeys_Range(n.right,left,right);
		}

		else if(n.value>right){

			printKeys_Range(n.left,left,right);
		}

	}

	public static void main(String[] args) {
		

		BST tree = new BST();
      	tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        
     
        tree.printKeys_Range(tree.root,10,25);
		
	}
}