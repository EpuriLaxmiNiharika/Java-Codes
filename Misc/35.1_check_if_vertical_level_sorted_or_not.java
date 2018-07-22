import java.util.*;
import java.util.Map.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}

class qNode{

	Node node;
	int width;
}

class BinaryTree{

	Node root;

	void verticalOrderTraversal(int level){

		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

		Queue<qNode> queue = new LinkedList<qNode>();

		qNode node1 = new qNode();
		node1.node = root;
		node1.width = 0;

		queue.add(node1);

		while (!queue.isEmpty()) {
			
			qNode popped = queue.remove();

			ArrayList<Integer> lst = map.get(popped.width);

			if(lst==null){
				lst = new ArrayList<Integer>();
			}

			lst.add(popped.node.value);

			map.put(popped.width,lst);

			if(popped.node.left!=null){
				qNode node2 = new qNode();
				node2.node = popped.node.left;
				node2.width = popped.width-1;
				queue.add(node2);
			}


			if(popped.node.right!=null){
				qNode node2 = new qNode();
				node2.node = popped.node.right;
				node2.width = popped.width+1;
				queue.add(node2);
			}
		}

		ArrayList<Integer> ele = map.get(level);

		for (int i = 1; i<ele.size();i++ ) {
			
			if(ele.get(i)<ele.get(i-1)){
				System.out.println("not sorted");
				return;
			}
		}

		System.out.println(" sorted");
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        
        Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(5);
	    root.left.left = new Node(7);
	    root.left.right = new Node(4);
	    root.left.right.left = new Node(6);
	    tree.root = root;
	
 		tree.verticalOrderTraversal(1);
	}
}