class Node{

	int value;
	Node left;
	Node right;
	int left_cnt = 0;

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
				temp.left_cnt = temp.left_cnt+1;
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

	void kth_smallest(int k){

		Node temp = root;
		// Node prev_temp = null;

		while(temp!=null){

			int temp_left_cnt = temp.left_cnt;

			if((temp_left_cnt+1)==k){
				System.out.print(temp.value);
				break;
				// return temp;
			}
			else if(temp_left_cnt < k){
				k = k - temp_left_cnt -1;
				temp = temp.right;
			}
			else{
				temp = temp.left;
			}
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
						System.out.println(current.value+" ---- "+current.left_cnt);
						current = current.right;
					}
				}

			else{
				System.out.println(current.value+" ---- "+current.left_cnt);
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
    	bst.kth_smallest(3);
	}
}