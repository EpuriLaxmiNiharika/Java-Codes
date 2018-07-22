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

	void verticalWidthUtil(Node node, Wrapper max_width, Wrapper min_width ,int width){
		
		if(node==null){
			return ;
		}
		
		if(width<min_width.val){
			min_width.val = width;
		}

		if(width>max_width.val){
			max_width.val = width;
		}
		
		verticalWidthUtil(node.left,min_width,max_width,width-1);

		verticalWidthUtil(node.right,min_width,max_width,width+1);
	}


	int verticalWidth(){

		Wrapper min_width = new Wrapper();
		Wrapper max_width = new Wrapper();

		verticalWidthUtil(root,min_width,max_width,0);

		return max_width.val  + Math.abs(min_width.val) + 1;
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