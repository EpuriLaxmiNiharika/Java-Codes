
/*
Morris Inorder order traversal. We are trying to build linkedlist to remember past history.
*/

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

class inorder{ 

	Node root;

	void inOrderTraversal(){
		Node current = root;
		Node temp = null;

		while (current!=null) {
			if(current.left!=null){
				temp = current.left;
				while(temp.right!=null && temp.right!=current){
					temp = temp.right;
				}

				if(temp.right==null){
					temp.right = current;
					current = current.left;
				}

				else if(temp.right==current){
					temp.right = null;
					System.out.print(" "+current.data); // because left root right and temp.right==current means left side is already visited so we can print root
					current = current.right;
				}
			}

			else{
				System.out.print(" "+current.data);
				current = current.right;
			}	

		}

		
	}

	public static void main(String[] args) {
		
		inorder tree = new inorder();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Preorder traversal of binary tree is ");
        tree.inOrderTraversal();

	}
}