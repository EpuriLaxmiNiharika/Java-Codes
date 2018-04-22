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

	public void preOrderTraversal(){ // root left right
		
		Stack<Node> stack = new Stack<Node>();
		if(root==null) return;
				
		stack.push(root);

		while (!stack.isEmpty()) {
			Node top = stack.pop();
			System.out.print(" "+top.data);
			if(top.right!=null){
				stack.push(top.right);
			}

			if(top.left!=null){
				stack.push(top.left);
			}
		}

	}



	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrderTraversal();
	}
}