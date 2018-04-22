class Node{

	Node left;
	Node right;
	int data;

	Node(int data){
		left = null;
		right = null;
		this.data = data;
	}
}

class Tree{
	Node root;

	Tree(){
		root = null;
	}

	public void morrisPreOrderTraversal(){

		Node current = root;

		while (current!=null) {
			
			if(current.left==null){
				System.out.print(" "+current.data);
				current = current.right;
			}
			else{
				Node temp = current.left;

				while(temp.right!=null && temp.right!=current){
					temp = temp.right;
				}

				if(temp.right==null){
					System.out.print(" "+current.data); // because  root left right, temp.right!=current means left side is not yet so we should print root before visited print root
					temp.right = current;
					current = current.left;
				}
				else{
					temp.right = null;
					current = current.right;
				}
			}
		}
	}


public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.morrisPreOrderTraversal();
	}

}