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

	void connectNodes(Node node){

		if(node==null){
			return;
		}

		if(node.left!=null){
			node.left.nextRight = node.right;
		}

		if(node.right!=null){

			node.right.nextRight = (node.nextRight!=null? node.nextRight.left:null);
		}

		connectNodes(node.left);
		connectNodes(node.right);
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);

        tree.connectNodes(tree.root);

         System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.data + " is "
                + a);
        int b = tree.root.left.nextRight != null ? 
                                    tree.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.data + " is "
                + b);
        int c = tree.root.right.nextRight != null ? 
                                   tree.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.right.data + " is "
                + c);
        int d = tree.root.left.left.nextRight != null ? 
                              tree.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.left.data + " is "
                + d); 
	}
}	