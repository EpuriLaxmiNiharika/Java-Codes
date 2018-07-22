/*
	
	Create a map like, map where key is the horizontal distance and value is a pair(a, b) 
	where a is the value of the node and b is the height of the node. 

	Perform a pre-order traversal of the tree. If the current node at a horizontal distance 
	of h is the first we’ve seen, insert it in the map. Otherwise, compare the node with the 
	existing one in map and if the height of the new node is greater, update in the Map.
	
*/


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

class Pair{

	int value;
	int height;

	Pair(int value, int height){

		this.value = value; 
		this.height = height;
	}
}

class BinaryTree{

	Node root;

	void BottomViewUtil(Node node, TreeMap<Integer,Pair> map, int height, int width){

		if(node==null){
			return;
		}
		
		if(map.get(width)==null){

			map.put(width,new Pair(node.value,height));
		}

		else {
			Pair pair = map.get(width);

			if(height>=pair.height){
				map.put(width,new Pair(node.value,height));
			}
		}

		BottomViewUtil(node.left,map,height+1,width-1);
		BottomViewUtil(node.right,map,height+1,width+1);
	}
	
	void BottomView(){

		TreeMap<Integer,Pair> map = new TreeMap<Integer,Pair>();
		BottomViewUtil(root,map,0,0);

		for(Entry<Integer,Pair> entry: map.entrySet()){

			int key = entry.getKey();
			Pair pair = map.get(key);

			System.out.println(pair.value);
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