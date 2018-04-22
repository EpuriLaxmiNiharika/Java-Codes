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

	public void inorderTraversal(Node root_node){
		
		if(root_node==null){
			return;
		}
		Node temp = root;
		inorderTraversal(root_node.left);
		System.out.print(" "+root_node.value);
		inorderTraversal(root_node.right);

	}

	public static void main(String[] args) {
		Tree tree  = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left= new Node(4);
       	tree.root.left.right= new Node(5);
       	tree.inorderTraversal(tree.root);
	}
}