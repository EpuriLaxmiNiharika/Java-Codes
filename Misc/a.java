import java.util.*;

class Node{

	int val;
	Node left;
	Node right;

	Node(int val){

		this.val = val;
	}
}

class BTREE{

	public static void main(String[] args) {
			
		Queue<Node> queue = new LinkedList<Node>();

		Node node = new Node(10);
		
		Node left = new Node(20);
		
		node.left = left;
		
		Node node2 = node.left;
		
		queue.add(node.left);

		node.left = null;

		if(node2!=null){
			System.out.println("sas");
		}
	}
}