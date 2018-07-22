// width of a level - num of nodes in that level
// width of tree- max(width of all levels) 

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

	int height(Node node){

		if(node==null){
			return 0;
		}

		int left = height(node.left);
		int right = height(node.right);

		return Math.max(left,right)+1;
	}


	void maxWidth(){

		int heightTree = height(root);

		int max_width  = 1;// root node

		for(int i = 1; i<heightTree;i++){

			int width = getwidth(root, i);
			max_width = Math.max(width,max_width);
		}

		System.out.println(max_width);	
	}


	int getwidth(Node node, int level){

		if(node == null){
			return 0;
		}

		if(level==0){
			return 1;
		}

		if(level>0){
			return getwidth(node.left,level-1)+getwidth(node.right,level-1);
		}

		else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
 	
 		tree.maxWidth();
       
	}
}