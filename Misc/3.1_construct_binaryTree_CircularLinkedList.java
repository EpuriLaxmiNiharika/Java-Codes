//https://www.youtube.com/watch?v=FsxTX7-yhOw

// THIS APPROACH CREATES NEW LINKEDLIST. IT DOESNT MODIFY THE EXISTING ONE

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}

	Node(){

	}
}


class BinaryTree{

	Node root;

	static Node prev; // holds the inorder predecessor of a node

	static Node head = new Node();

	void convertInorder(Node node){

		if(node==null){
			return;
		}

		convertInorder(node.left);

		if(prev==null){
			head = node;
		}

		else {
			node.left = prev;
			prev.right = node;
		}

		prev = node;
		//System.out.println(prev.value);

		convertInorder(node.right);
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        tree.convertInorder(tree.root);
 	
 		Node temp =tree.head;
 		while (temp!=null) {
 			System.out.print(temp.value+"  ");
 			temp = temp.right;
 		}
	}
}