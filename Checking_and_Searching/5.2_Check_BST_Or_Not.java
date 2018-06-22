/* 

		Returns true if the given tree is a binary search tree 
		 (efficient version). 

		int isBST(struct node* node) 
		{ 
		  return(isBSTUtil(node, INT_MIN, INT_MAX)); 
		} 

		/* Returns true if the given tree is a BST and its 
		 values are >= min and <= max. *

		int isBSTUtil(struct node* node, int min, int max) 

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

	void insert(int value){

		if(root == null){
			root = new Node(value);
			return;
		}

		Node temp = root;
		Node prev_temp = temp;	
		while(temp!=null){
			prev_temp = temp;
			if(temp.value< value){
				temp=temp.right;
			}
			else{
				temp = temp.right;
			}
		}

		if(prev_temp.value<value){
			prev_temp.right =  new Node(value);
			return;
		}
		prev_temp.left = new Node(value);
	}


	void inorderTraversal(Node node){

		if(node==null){

			return;
		}

		inorderTraversal(node.left);
		System.out.print(node.value+" ");
		inorderTraversal(node.right);
	}



	boolean isBST(Node node, int min, int max){

		if(node==null){
			return true;
		}

		if(node.value<min || node.value>max){
			return false;
		}

		return isBST(node.left,min,node.value-1) && isBST(node.right, node.value+1,max);
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
    	if(bst.isBST(bst.root,Integer.MIN_VALUE, Integer.MAX_VALUE)){
    		System.out.println("yes");
    	}
    	else{
    		System.out.println("No");
    	}
	}
}