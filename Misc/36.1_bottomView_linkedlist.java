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

	void BottomView(){

		qNode prev = new qNode();
		prev.node = null;

		TreeMap<Integer,Integer> map = new 	TreeMap<Integer,Integer>();

		Queue<qNode> queue = new LinkedList<qNode>();

		qNode node1 = new qNode();
		node1.node = root;
		node1.width = 0;

		queue.add(node1);

		while (!queue.isEmpty()) {
			
			qNode popped = queue.remove();

			map.put(popped.width,popped.node.value);

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


		for(Entry<Integer,Integer> entry: map.entrySet()){

			int key = entry.getKey();
			int value = entry.getValue();

			System.out.println(value);
		}
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        
       	Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);


		tree.root = root;
 		tree.BottomView();
	}
}