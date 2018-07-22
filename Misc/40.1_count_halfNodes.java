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

	static int count;

	void countHalfNodes(Node node){
		
		if(node==null){
			return ;
		}
		
		if(node.left==null && node.right==null);

		else if(node.left==null || node.right==null){

			count++;
		}
		
		countHalfNodes(node.left);
		
		countHalfNodes(node.right);
	}



	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);
		
		tree.countHalfNodes(tree.root);
 		System.out.println(tree.count);
       
	}
}