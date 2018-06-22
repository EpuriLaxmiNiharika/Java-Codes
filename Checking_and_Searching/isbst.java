

import java.util.*;

class Node{

	int value;

	Node left;
	Node right;

	int left_min = -1;
	int right_max = -1;

	Node(int value){
		this.value = value;
	}
}



class BST{

	Node root;
	 Node prev = null;
	 Node next;

	 void ceilFloor(Node node){

		if(node==null){
			return;
		}

		ceilFloor(node.left);
		
				next = node.right;

		if(prev==null){
			node.left_min = -1;

		}


		else{
			node.left_min = prev.value;
			if(next!=null){
				System.out.println("node: "+node.value+"left: "+prev.value+"right: "+next.value);
				node.right_max = next.value;
			}
			else{
				node.right_max = -1;
			}
		}

		prev =node;
		ceilFloor(node.right);
	}

	void inorder(Node n){
		if(n==null){
			return;
		}

		inorder(n.left);
		System.out.println(n.value+"---"+n.left_min+"---"+n.right_max);
		inorder(n.right);
	}


	public static void main(String[] args) {
		BST tree = new BST();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        tree.next= tree.root;
        tree.ceilFloor(tree.root);
       	tree.inorder(tree.root);
		
	}
}