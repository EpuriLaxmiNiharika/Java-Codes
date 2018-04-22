/*

In stack first insert rightchild then parent and leftchild; Because as it is inorder traversal the popping of elements should first show left,parent and right.

Mark a node as visited whenever you insert you insert it's left and right child.
*/


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

class inorder{ 

	Node root;

	Stack<Node> stack = new Stack<Node>();

	void inOrderTraversal(){

		Node temp = root.left;

		stack.push(root);

		temp = stack.pop();

		while (temp!=null) {
			stack.push(temp);
			temp = temp.left;
		}

		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(" "+temp.data);

			if(temp.right!=null){
				temp = temp.right;
				while(temp!=null){
					stack.push(temp);
					temp = temp.left;
				}
			}			
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