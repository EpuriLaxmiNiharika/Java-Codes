// We are deleting tree nodes in Level Order fashion. 

import java.util.*;

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

	void levelOrder(){

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {
			
			Node popped = queue.remove();

			if(popped.left!=null){

				queue.add(popped.left);
				popped.left = null;
				System.out.println("Deleted left child of : " + popped.value);
			}

			if(popped.right!=null){

				queue.add(popped.right);
				popped.right = null;
				System.out.println("Deleted right child of : " + popped.value);
			}
		}

		root = null;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(25);

        tree.levelOrder();
	}
}