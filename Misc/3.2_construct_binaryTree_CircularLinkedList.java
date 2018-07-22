//https://www.youtube.com/watch?v=Dte6EF1nHNo

// THIS APPROACH MODIFY THE EXISTING BINARY TREE

// HERE WE ARE CONVERTING TO CIRCULAR DOUBLY LINKED LIST

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

	public Node concatenate(Node a, Node b){ // a and b are circular linkedlists

		if(a==null){
			return b;
		}

		if(b==null){
			return a;
		}

		// a is the head of the linkedlist
		// b is the head of linkedlist

		Node aEnd = a.left;
		Node bEnd = b.right;

		a.left = bEnd;
		bEnd.right = a;

		aEnd.right = b;
		b.left = aEnd;

		return a;
	}


	Node convertDoublyLinkedList(Node node){

		if(node==null){
			return node;
		}

		Node leftTree = convertDoublyLinkedList(node.left);
		Node rightTree = convertDoublyLinkedList(node.right);

		node.right = node;
		node.left = node;

		// concatente lefttree and node

		node = concatenate(leftTree,node);
		node = concatenate(node,rightTree);

		return node;
	}


	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        Node node = tree.convertDoublyLinkedList(tree.root);
 	
 		System.out.println(node.value);

 		Node temp = node.right;

 		while (temp!=null && temp.value!=node.value) {
 			System.out.print(temp.value+"  ");
 			temp = temp.right;
 		}
	}
}