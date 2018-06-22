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

	Node construct_BST(int[] preorder, int start, int end){

		if(start>end || end>preorder.length-1 || start>=preorder.length){
			return null;
		}

		Node new_node = new Node(preorder[start]);

		int i = start+1;
		for( i = start+1;i<=end;i++){

			if(preorder[i]>new_node.value){
				break;
			}
		}

		new_node.left = construct_BST(preorder,start+1,i-1);
		new_node.right = construct_BST(preorder,i,end);

		return new_node;
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
		bst.root = bst.construct_BST(preorder,0,preorder.length-1);
		bst.morris_inorder();
	}
}