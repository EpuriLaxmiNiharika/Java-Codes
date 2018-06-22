/*

	 if all internal nodes have only one child in a BST, then all the descendants of every node are either smaller or larger than the node. 
	 The reason is simple, since the tree is BST and every node has only one child, all descendants of a node will either be on left side or right side, 
	 means all descendants will either be smaller or greater.

*/

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

		for(int i = 0; i<preorder.length-1;i++){
			int ele =preorder[i];
			int ele_next = preorder[i+1];
			boolean isgreater = false;
			if(ele_next>ele){
				isgreater = true;
			}
			for(int j = i+2; j<preorder.length;j++){

				if(isgreater){
					if(preorder[j]<preorder[i]){
						System.out.println("false");
						return;
					}
				}

				else if(!isgreater){// lesser
					if(preorder[j]>preorder[i]){
						System.out.println("false");
						return;
					}
				}
			}
		}
		System.out.println("true");
	}

	public static void main(String[] args) {
		hasOnlyOneChild(new int[]{20, 10, 11, 13, 12});
	}
}