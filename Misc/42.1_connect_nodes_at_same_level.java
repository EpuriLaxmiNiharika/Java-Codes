import java.util.*;

class Node{

	int data;
	Node left;
	Node right;
	Node nextRight;

	Node(int data){

		this.data = data;
	}
}

class BinaryTree{

	Node root;

	void connectNodes(){

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node popped =queue.remove();

			if(popped==null){

				if(queue.isEmpty()){
					return;
				}
				
				queue.add(popped);
			}

			else {
				popped.nextRight = queue.peek();
				if(popped.left!=null){
					queue.add(popped.left);
				}

				if(popped.right!=null){
					queue.add(popped.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.right.right = new Node(90);

        tree.connectNodes();

        System.out.println("Following are populated nextRight pointers in \n" +
      "the tree (-1 is printed if there is no nextRight)");
        System.out.println("nextRight of "+ tree.root.data +" is "+
        ((tree.root.nextRight != null) ? tree.root.nextRight.data : -1));
        System.out.println("nextRight of "+ tree.root.left.data+" is "+
        ((tree.root.left.nextRight != null) ? tree.root.left.nextRight.data : -1));
        System.out.println("nextRight of "+ tree.root.right.data+" is "+
        ((tree.root.right.nextRight != null) ? tree.root.right.nextRight.data : -1));
        System.out.println("nextRight of "+  tree.root.left.left.data+" is "+
        ((tree.root.left.left.nextRight != null) ? tree.root.left.left.nextRight.data : -1));
        System.out.println("nextRight of "+  tree.root.right.right.data+" is "+
        ((tree.root.right.right.nextRight != null) ? tree.root.right.right.nextRight.data : -1));
	}
}	