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

	Node buildTree(int[] arr, Node node, int node_index){
		
		if(node_index>=arr.length){
			return null;
		}

		node = new Node(arr[node_index]);
		node.left = buildTree(arr, node.left, 2*node_index+1);
		node.right = buildTree(arr, node.right, 2*node_index+2);
		return node;
	}

	void inorderTraversal(Node node) {
        if (node != null) 
        {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        tree.root = tree.buildTree(arr, tree.root,0);
        tree.inorderTraversal(tree.root);
	}
}