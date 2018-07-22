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

	void verticalOrderTraversal(){

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


		for(Entry<Integer,ArrayList<Integer>> entry: map.entrySet()){

			int key = entry.getKey();
			ArrayList<Integer> lst = map.get(key);

			for(int i = 0; i<lst.size();i++){
				System.out.print(lst.get(i)+" ");
			}

			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
   	 	root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.right.left.right = new Node(8);
	    root.right.right.right = new Node(9);
	    root.right.right.left= new Node(10);
	    root.right.right.left.right= new Node(11);
	    root.right.right.left.right.right= new Node(12);
	    tree.root = root;
	
 		tree.verticalOrderTraversal();
	}
}