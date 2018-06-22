import java.util.*;

class Node{

	int value;

	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class BST{

	Node root;

	Node LCA(Node root_node, int n1, int n2){

		while (root_node!=null) {
			if(root_node.value<n1 && root_node.value<n2){
				root_node = root_node.right;
			}
			if(root_node.value>n1 && root_node.value>n2){
				root_node = root_node.left;
			}
			else {
				break;
			}
		}
		return root_node;
	}

	public static void main(String[] args) {
		
		BST tree = new BST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
  
        int n1 = 10, n2 = 14;
        Node t = tree.LCA(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.value);
	}
}
