import java.util.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}


class qNode{  // node and its depth

	Node node;
	int depth;

	qNode(Node node, int depth){

		this.node = node;
		this.depth = depth;
	}
}


class BinaryTree{

	Node root;

	int minDepth(){

		Queue<qNode> queue = new LinkedList<qNode>();

		int height = 1;
		
		qNode root_qnode = new qNode(root,1);
		queue.add(root_qnode);

		while (!queue.isEmpty()) {
				
			qNode node = queue.remove();
			Node popped = node.node;

			if(popped.left==null && popped.right==null){
				height = node.depth;
				return node.depth;
			}

			else{

				if(popped.left!=null){
					queue.add( new qNode(popped.left,node.depth+1));
				}

				if(popped.right!=null){
					queue.add(new qNode(popped.right,node.depth+1));
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