/*
	What is a successor and predecessor: https://www.youtube.com/watch?v=JdmAYw5h3G8&t=308s
	Threaded binary trees -- watch 0 to 9:50: https://www.youtube.com/watch?v=ffgg_zmbaxw
	Morris algo: https://www.youtube.com/watch?v=wGXB9OWhPTg&t=412s

*/

class Node{
	Node leftChild;
	Node rightChild;
//	Node next;
	int value;

	public Node(int value){
		this.value = value;
		leftChild = rightChild  = null;
		// next = null
	}
}

class BinaryTree{
	Node root;

	public BinaryTree(){
		root = null;
	}

	public void Morris_InorderTraversal(){
		Node current = root;
		
		while (current!=null) {

			if(current.leftChild==null){
				System.out.print(" "+ current.value);
				current = current.rightChild;
			}

			else{ // current.leftchild is not null
				Node predecessor = current.leftChild; 
				while(predecessor.rightChild!=null && predecessor.rightChild!=current){ // find the predecessor of the leftchild and make pred.next = current.
																						// predecessor of parent is rightmost node of its child subtree.
																						// because in anyorder traversal after predecessor only parent comes.
																						//We are doing this because we need to somewhere remember our parent nodes of child for inorder traversal (we are creating sort of linked list). Using stack we remembered parent nodes by putting in stack.
						predecessor = predecessor.rightChild;
				}
				if(predecessor.rightChild == null){
					predecessor.rightChild = current;
					current = current.leftChild;
				}
				
				if(predecessor.rightChild == current){ // means left nodes is already visited
					System.out.print(" " + current.value);
					predecessor.rightChild = null;
					current = current.rightChild;
				}
				
			}

		}

	}


	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
          
        tree.Morris_InorderTraversal();
	}

}