// OUTPUT INCREASING ORDER OF KEYS  GUARENTEE... 

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


	void printKeys_Range(Node n, int left, int right){

		if(n==null){
			return;
		}

		// System.out.println(n.value+"---"+left+"---"+right);

		if(n.value>=left){
			printKeys_Range(n.left,left,right);
		}


		if(n.value>=left && n.value <=right){
			System.out.print(n.value+" ");
		}

		if(n.value<=right){
			printKeys_Range(n.right,left,right);
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