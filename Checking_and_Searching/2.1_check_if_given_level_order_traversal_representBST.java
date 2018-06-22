import java.util.*;

class Node{

	int value;

	int left_min = Integer.MIN_VALUE;
	int right_max = Integer.MAX_VALUE;

	Node(int value){
		this.value = value;
	}
}

class BST{

	Node root;

	void isBST(int[] levelorder){

		Queue<Node> queue = new LinkedList<Node>();
		root = new Node(levelorder[0]);
		queue.add(root);
		int index = 1;

		while (!queue.isEmpty() && index!=levelorder.length) {
			Node dequeue = queue.remove();

			 if(dequeue.value > levelorder[index] && dequeue.left_min < levelorder[index]){
				Node left_node = new Node(levelorder[index]);
				index++;
				left_node.left_min = dequeue.left_min;
				left_node.right_max = dequeue.value;
				queue.add(left_node);
			}

			if(dequeue.value < levelorder[index] && dequeue.right_max>levelorder[index]){
				Node right_node = new Node(levelorder[index]);
				index++;
				right_node.left_min = dequeue.value;
				right_node.right_max = dequeue.right_max;
				queue.add(right_node);
			}
		}

		if(index==levelorder.length){
			System.out.println("yes");
			return;
		}
		System.out.println("No");
	}

	public static void main(String[] args) {
		BST bst = new BST();
		int levelorder[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}; 
		bst.isBST(levelorder);
	}
}