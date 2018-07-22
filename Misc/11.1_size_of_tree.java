// idea is --- postorder traversal without stack and without recursion

//PlacementsPrepV2/DataStructures/Trees/BinaryTrees/traversals/
//25.1_postorder_traversal_without_stack_without_recursion.java 


//PlacementsPrepV2/DataStructures/Trees/BinaryTrees/traversals/
//25.2_postorder_traversal_without_stack_without_recursion.java 



import java.util.*;

class Node{

	int data;
	Node left;
	Node right;

	Node(int value){

		this.data = value;
	}
}

class BinaryTree{

	Node root;

	int sizeTree(){

		Node temp = root;

		int size = 0;

		Set<Integer> visited = new HashSet<Integer>();

		while (temp!=null && !visited.contains(temp.data)) {
			
			if(temp.left!=null  && !visited.contains(temp.left.data)){
				temp = temp.left;
			}

			else if(temp.right!=null && !visited.contains(temp.right.data)){
				temp = temp.right;
			}

			else {
				size++;
				visited.add(temp.data);
				temp = root;
			}

		}
   
		return size;
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

        System.out.println(tree.sizeTree());
	}
}