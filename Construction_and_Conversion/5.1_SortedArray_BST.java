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

	Node constructBST(int[] arr, int start, int end){

		if(start>end){
			return null;
		}

		int middle_index = (start+end)/2;
		Node root = new Node(arr[middle_index]);
		root.left = constructBST(arr,start,middle_index-1);
		root.right = constructBST(arr,middle_index+1,end);
		return root;

	}

	public static void main(String[] args) {
		BST bst = new BST();
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		bst.root = bst.constructBST(arr,0,arr.length-1);
		bst.morris_inorder();
	}
}