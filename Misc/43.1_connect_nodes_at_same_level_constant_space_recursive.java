

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
	Node nextRight;
}


class BinaryTree{

	Node root;
	

	void connect(Node node){ // root

		if(node==null){
			return;
		}

		if(node.nextRight!=null){
			connect(node.nextRight);
		}

		if(node.left!=null){

			if(node.right!=null){
				node.left.nextRight = node.right;
				node.right.nextRight = nextRight(node);
			}

			else{
				node.left.nextRight = nextRight(node);
			}

			connect(node.left);
		}

		else if(node.right!=null){

			node.right.nextRight = nextRight(node);
			connect(node.right);
		}
		else {
		//	connect(nextRight(node));
		}
	}


	Node nextRight(Node n){

		Node temp = n.nextRight;

		while(temp!=null){

			if(temp.left!=null){
				return temp.left;
			}

			else if(temp.right!=null){
				return  temp.right;
			}

			temp = temp.nextRight;
		}
		return null;
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);

        tree.connect(tree.root);

         System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.value : -1;
        System.out.println("nextRight of " + tree.root.value + " is "
                + a);
        int b = tree.root.left.nextRight != null ? 
                                    tree.root.left.nextRight.value : -1;
        System.out.println("nextRight of " + tree.root.left.value + " is "
                + b);
        int c = tree.root.right.nextRight != null ? 
                                   tree.root.right.nextRight.value : -1;
        System.out.println("nextRight of " + tree.root.right.value + " is "
                + c);
        int d = tree.root.left.left.nextRight != null ? 
                              tree.root.left.left.nextRight.value : -1;
        System.out.println("nextRight of " + tree.root.left.left.value + " is "
                + d); 
	}
}