/*
	O(N^3)

	So for identifying whether the given Preorder traversal is valid sequence of BST,
	For each node(A), we will first identify the start of Right sub-tree and then check all element 
	after start of Right sub tree should be greater than A. 
	If we found any element less than A then it is not valid Preorder sequence.
*/

import java.util.*;

class Node{

	int value;

	int left_min = Integer.MIN_VALUE;
	int right_max = Integer.MAX_VALUE;

	Node(int value){
		this.value = value;
	}
}

class BST{

	Node root;

	void isBST(int[] preorder){

		for(int i = 0; i<preorder.length;i++){
			boolean great_ele_found = false;
			for(int j = 1; j<preorder.length;j++){
				if(preorder[j]>preorder[i] && !great_ele_found){
					great_ele_found = true;
					if(!checkBST(preorder, i, j)){ // right sub tree...
						System.out.println("no");
						return;
					}
				}
				if(great_ele_found){
					break;
				}
			}
		}
		System.out.println("yes");
	}

	boolean checkBST(int[] preorder, int index1, int index2){

		int ele = preorder[index1];

		for(int i = index2;i<preorder.length;i++){
			if(preorder[i]<ele){
				return  false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		BST bst = new BST();
		int preorder[] = {40, 30, 35, 80, 100}; 
		bst.isBST(preorder);
	}
}