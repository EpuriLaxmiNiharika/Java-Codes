/*

The idea is to use a stack to get the reverse level order. 
If we do normal level order traversal and instead of printing a node, push the node to a stack and then print contents of stack, 
we get “5 4 3 2 1” for above example tree, but output should be “4 5 2 3 1”. 
So to get the correct sequence (left to right at every level), we process children of a node in reverse order, 
we first push the right subtree to stack, then left subtree.

*/


import java.util.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
		left = right = null;
	}
}


class BinaryTree{

	Node root;

	void reverseLevelOrder(Node root){

		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();

		if(root!=null){
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			stack.add(temp);

			if(temp.right!=null){
				queue.add(temp.right);
			}
			if(temp.left!=null){
				queue.add(temp.left);
			}
		}

		while(!stack.isEmpty()){
			System.out.print(" "+stack.pop().value);
		}

	}


	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
  
        // Let us create trees shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
          
        System.out.println("Level Order traversal of binary tree is : ");
        tree.reverseLevelOrder(tree.root);
	}

}