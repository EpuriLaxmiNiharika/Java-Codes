import java.util.Stack;

class Node{

	Node left;
	Node right;
	int data;

	Node(int data){
		left = null;
		right = null;
		this.data = data;
	}
}

class Tree{
	Node root;

	Tree(){
		root = null;
	}

	public void printLevelOrder(){
		int height = heightTree(root);
		for(int i = 0; i<height;i++){
			printLevelNodes(i,root);
			System.out.println("\n");
		}
	}


	public int heightTree(Node node){
		if(node==null) return 0;
		int height = 0;
		int max = 0;
		int left = heightTree(node.left);
		int right = heightTree(node.right);
		max = left;
		if(max<right){
			max = right;
		}
		return 1 + max;
	}

	public void printLevelNodes(int level, Node node){

		if(node==null){
			return;
		}

		if(level==0){
			System.out.print(" "+node.data);
		}

		printLevelNodes(level-1,node.left);
		printLevelNodes(level-1,node.right);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Level traversal of binary tree is ");
        tree.printLevelOrder();
	}
}