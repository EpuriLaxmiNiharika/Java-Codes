import java.util.*;

class Node{

	int data;
	Node left;
	Node right;

	Node(int value){

		this.data = value;
	}
	Node nextRight;
}


class BinaryTree{

	Node root;
	

	public void LevelOrder(){

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		int max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			Node dequeued = q.remove();
			if(dequeued==null){

				System.out.println(max);
				max = Integer.MIN_VALUE;
				if(!q.isEmpty()){
					System.out.println();
					q.add(dequeued);
				}
			}

			else{

				if(max<dequeued.data){
					max = dequeued.data;
				}

				if(dequeued.left!=null){
					q.add(dequeued.left);
				}
				if(dequeued.right!=null){
					q.add(dequeued.right);
				}
			}
		}
	}


	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();

		Node root = null;
	    root = new Node(4);
	    root.left = new Node(9);
	    root.right = new Node(2);
	    root.left.left = new Node(3);
	    root.left.right = new Node(5);
	    root.right.right = new Node(7);

	    tree.root = root;

	    tree.LevelOrder();
	}
}