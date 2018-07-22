// width of a level - num of nodes in that level

// use queue for level order traversal.. and at each level find the max number of ndoes in that level

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


	void maxWidth(){

		int max_width  = Integer.MIN_VALUE;// root node

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();

			max_width = Math.max(max_width, size);

			while(size>0){
				Node popped = queue.remove();

				if(popped.left!=null){
					queue.add(popped.left);
				}

				if(popped.right!=null){
					queue.add(popped.right);
				}

				size--;
			}
		}

		System.out.println(max_width);
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