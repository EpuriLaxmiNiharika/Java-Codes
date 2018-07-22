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

class Wrapper{
	int min;
	int max;
}

class BinaryTree{

	Node root;

	void min_max_horizontalDist(Node n, Wrapper wrapper, int width){

		if(n==null){
			return;
		}

		if(width<wrapper.min){
			wrapper.min = width;
		}

		if(width>wrapper.max){
			wrapper.max = width;
		}

		min_max_horizontalDist(n.left,wrapper,width-1);
		min_max_horizontalDist(n.right,wrapper,width+1);
	}


	void verticalOrderTraversalUtil(Node node, int index, int width){
		
		if(node==null){
			return ;
		}
			
		if(width==index){
			System.out.print(node.value+" ");
		}

		
		verticalOrderTraversalUtil(node.left,index, width-1);
		verticalOrderTraversalUtil(node.right,index, width+1);
	}


	void verticalOrderTraversal(){

		Wrapper wrapper = new Wrapper();

		min_max_horizontalDist(root,wrapper,0);

		for(int i = wrapper.min; i<=wrapper.max;i++){

			verticalOrderTraversalUtil(root,i,0);
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