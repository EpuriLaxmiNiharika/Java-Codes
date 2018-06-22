class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class BST{

	Node root;

	void insert(int value){

		if(root==null){
			root = new Node(value);
			return;
		}

		Node temp = root;
		Node prev_temp = null;

		while (temp!=null) {
			prev_temp = temp;

			if(value<temp.value){
				temp = temp.left;
			}

			else{
				temp = temp.right;
			}
		}

		if(prev_temp.value<value){
			prev_temp.right = new Node(value);
		}

		else{
			prev_temp.left = new Node(value);
		}
	}

	void morris_inorder(){

		Node current = root;

		while(current!=null){

			if(current.left!=null){
					Node inorder_pred = current.left;
					while(inorder_pred.right!=null && inorder_pred.right!=current){
						inorder_pred = inorder_pred.right;
					}
					if(inorder_pred.right==null){	
						inorder_pred.right = current;
						current = current.left;
					}

					else{	
						inorder_pred.right = null;
						System.out.print(current.value+" ");
						current = current.right;
					}
				}

			else{
				System.out.print(current.value+" ");
				current = current.right;
			}
		}
	}

	void inorderTraversal(Node node){

		if(node==null){

			return;
		}

		inorderTraversal(node.left);
		System.out.print(node.value+" ");
		inorderTraversal(node.right);
	}

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.insert(50);
    	bst.insert(30);
    	bst.insert(20);
    	bst.insert(40);
    	bst.insert(70);
    	bst.insert(60);
    	bst.insert(80);
    	bst.morris_inorder();
	}
}