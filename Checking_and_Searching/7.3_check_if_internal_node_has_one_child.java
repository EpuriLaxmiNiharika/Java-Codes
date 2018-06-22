

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

	static void hasOnlyOneChild(int[] preorder){

		int size = preorder.length;
		int min = preorder[size-1];
		int max = preorder[size-2];
		if(max<min){
			min = preorder[size-2];
			max = preorder[size-1];
		}

		for(int i = size-3; i>=0;i--){

			if(preorder[i]<min){ // means preorder(i) right subtree is preorder(i+1... end)
				min = preorder[i];
			}
			
			else if(preorder[i]>max){ // means preorder(i) left subtree is preorder(i+1... end)
				max = preorder[i];
			}
			else{
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
	}

	public static void main(String[] args) {
		hasOnlyOneChild(new int[]{30, 22, 21, 13, 14});
	}
}