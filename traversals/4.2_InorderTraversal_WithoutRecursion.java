/*

In stack first insert rightchild then parent and leftchild; Because as it is inorder traversal the popping of elements should first show left,parent and right.

Mark a node as visited whenever you insert you insert it's left and right child.
*/


import java.util.Stack;

class Node{

	Node left;
	Node right;
	int data;
	boolean visited;

	Node(int data){
		left = null;
		right = null;
		visited= false;
		this.data = data;
	}
}

class inorder{ 

	Node root;

	Stack<Node> stack = new Stack<Node>();

	void inOrderTraversal(){

		Node root_node = root;

		if(root_node==null){
			return ;
		}

		if(root_node.right!=null){
			stack.push(root_node.right);
		}

		stack.push(root_node);
		
		root_node.visited = true;

		if(root_node.left!=null){
			stack.push(root_node.left);
		}

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			
			if(temp.visited){
				System.out.print(" "+temp.data);
			}
			
			if(temp.right!=null && !temp.visited){
				stack.push(temp.right);
			}

			if(!temp.visited){
				stack.push(temp);
			}
			
			if(temp.left!=null && !temp.visited){
				stack.push(temp.left);
			}

			temp.visited = true;
		}
	
	}

	public static void main(String[] args) {
		
		inorder tree = new inorder();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.inOrderTraversal();

	}
}