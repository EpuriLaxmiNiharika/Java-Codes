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

	boolean isBST(int[] preorder, int start, int end, int min, int max){

		if(start>=end){
			return true;
		}

		int root =preorder[start];
		
		int max_index = start;
		for(int i = start+1; i<=end;i++){

			if(preorder[i]<min || preorder[i] > max){
				return false;
			}

			if(preorder[i]>root){
				break;
			}
			max_index++;
		}

		boolean left = isBST(preorder,start+1,max_index-1,min, preorder[start]-1);

		boolean right = isBST(preorder,max_index+1,end,preorder[start]+1, max);
	
		return left&&right;
	}


	public static void main(String[] args) {
		BST bst = new BST();
		int preorder[] = {40, 30, 35, 80, 100}; 
		if(bst.isBST(preorder,0,preorder.length-1,Integer.MIN_VALUE, Integer.MAX_VALUE)){
			System.out.println("yes");
		}
		else{
			System.out.println("no");
		}
	}
}