class Node{
	int value;
	Node left;
	Node right;
	public Node(int value){
		this.value = value;
		left = null;
		right = null;
	}
}

class Tree{

	Node root;
	int height;

	public Tree(){
		height = 0;
	}

	public void levelOrderTraversal(){
	
		int height = heightTree(root);
		for(int level = 1; level <=height ; level++){
			printNodesAtLevel(level,root);
		}
	}

	public void printNodesAtLevel(int level, Node root_node){
		
		if(root_node == null){
			return;
		}

		if(level ==1){
			System.out.print(root_node.value +" ");
			return;
		}
		else{
			printNodesAtLevel(level-1, root_node.left);
			printNodesAtLevel(level-1,root_node.right);
		}
	}

	public int heightTree(Node tree_root){
		
		if(tree_root == null){
			return 0;
		}

		int lheight = heightTree(tree_root.left);
		int rheight = heightTree(tree_root.right);
		
		if (lheight > rheight)
			return(lheight+1);
        
        else return(rheight+1); 
		
	}

	public static void main(String[] args) {
		Tree tree  = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left= new Node(4);
       	tree.root.left.left.left= new Node(5);
       	tree.levelOrderTraversal();
	}
}