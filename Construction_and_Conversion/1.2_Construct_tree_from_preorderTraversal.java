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
	static int preorder_index = 0;

	Node construct_BST(int[] preorder, int min, int max){

		if(preorder_index>preorder.length-1){
			return  null;
		}

		Node node = null;
		if(preorder[preorder_index] > min && preorder[preorder_index]<max){
			node = new Node(preorder[preorder_index]);
			preorder_index++;

			if(preorder_index<preorder.length){
				node.left = construct_BST(preorder,min,node.value-1);
				node.right = construct_BST(preorder,node.value+1,max);
			}
		}
		return node;
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

	public static void main(String[] args) {
		
		BST bst = new BST();
		int[] preorder = new int[]{10, 5, 1, 7, 40, 50};
		bst.root = bst.construct_BST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
		bst.morris_inorder();
	}
}