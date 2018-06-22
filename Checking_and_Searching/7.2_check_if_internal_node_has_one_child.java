/*

Since all the descendants of a node must either be larger or smaller than the node. We can do following for every node in a loop.
1. Find the next preorder successor (or descendant) of the node.
2. Find the last preorder successor (last element in pre[]) of the node.
3. If both successors are less than the current node, or both successors are greater than the current node, then continue. Else, return false.

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

		int prev = preorder[0];
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		for(int i = 1; i<preorder.length;i++){

			if(preorder[i]>=min && preorder[i]<=max){
				if(prev<preorder[i]){
					min = prev+1;
				}
				else{
					max = prev-1;
				}
				
			}
			else{
				System.out.println("no");
				return;
			}
			prev = preorder[i];
		}
		System.out.println("yes");
	}

	public static void main(String[] args) {
		hasOnlyOneChild(new int[]{20, 10, 21, 13, 8});
	}
}