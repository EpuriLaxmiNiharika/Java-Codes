import java.util.*;

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

	int minDepth(){

		Queue<Node> queue = new LinkedList<Node>();

		int height = 1;
		
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
				
			Node popped = queue.remove();

			if(popped==null){
				height++;
				if(!queue.isEmpty()){
					queue.add(null);
				}
				
				else {
					return height;
				}
			}

			else if(popped.left==null && popped.right==null){
				return  height;
			}

			else{

				if(popped.left!=null){
					queue.add(popped.left);
				}

				if(popped.right!=null){
					queue.add(popped.right);
				}
			}
		}	
		return height;
	}

	public static void main(String[] args) {
		
		 BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The minimum depth of "+
          "binary tree is : " + tree.minDepth());
	}
}