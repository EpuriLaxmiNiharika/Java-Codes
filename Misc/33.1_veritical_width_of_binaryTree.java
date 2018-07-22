import java.util.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}

class Wrapper{

	int val;
}


class BinaryTree{

	Node root;

	void verticalWidthUtil(Node node, Set<Integer>set,int width){
		
		if(node==null){
			return ;
		}
		set.add(width);
		
		verticalWidthUtil(node.left,set,width-1);
		
		verticalWidthUtil(node.right,set,width+1);
	}


	int verticalWidth(){

		Set<Integer> set = new HashSet<Integer>();

		verticalWidthUtil(root,set,0);

		return set.size();
		// 1 is added to contribute the width of vertical line of root
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

	    tree.root = root;
	
 		System.out.println(tree.verticalWidth());
       
	}
}