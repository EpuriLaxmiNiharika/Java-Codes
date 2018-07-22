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

class BinaryTree{

	Node root;

	void verticalOrderTraversalUtil(Node node, TreeMap<Integer, ArrayList<Integer>>hm,int width){
		
		if(node==null){
			return ;
		}
		
		ArrayList<Integer> lst = hm.get(width);

		if(lst==null){
			lst = new ArrayList<Integer>();
		}

		lst.add(node.value);

		hm.put(width,lst);
		
		verticalOrderTraversalUtil(node.left,hm,width-1);
		verticalOrderTraversalUtil(node.right,hm,width+1);
	}


	void verticalOrderTraversal(){

		TreeMap<Integer,ArrayList<Integer>> hm = new TreeMap<Integer,ArrayList<Integer>>();

		verticalOrderTraversalUtil(root,hm,0);

		for(Entry<Integer,ArrayList<Integer>> entry: hm.entrySet()){

			int key = entry.getKey();
			ArrayList<Integer> lst = hm.get(key);

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