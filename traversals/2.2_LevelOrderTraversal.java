import java.util.Queue;
import java.util.LinkedList;

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

class Tree{
	Node root;

	Tree(){
		root = null;
	}

	public void printLevelOrder(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print(temp.data+" ");
			if(temp.left!=null){
				queue.add(temp.left);
			}

			if(temp.right!=null){
				queue.add(temp.right);
			}


		}
	}


	

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Level traversal of binary tree is ");
        tree.printLevelOrder();
	}
}