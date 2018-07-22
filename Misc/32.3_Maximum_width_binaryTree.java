// width of a level - num of nodes in that level

// using preorder traversal and maintaining number of nodes at each level

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

	int height(Node node){

		if(node==null){
			return 0;
		}

		int left = height(node.left);
		int right = height(node.right);

		return Math.max(left,right)+1;
	}


	void maxWidth(){

		int[] count = new int[height(root)];
		Arrays.fill(count,0);

		maxWidthUtil(root, count , 0);

		int max = 0;

		for(int i = 0; i<count.length;i++){

			max = Math.max(count[i],max);
		}

		System.out.println(max);
	}
	

	void maxWidthUtil(Node node, int[] count, int height){ // preorder traversal

		if(node==null){
			return;
		}

		count[height]++; // count holds number of nodes with same height

		maxWidthUtil(node.left,count,height+1);
		maxWidthUtil(node.right,count,height+1);
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