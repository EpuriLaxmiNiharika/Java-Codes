/*
	IN BST -- PARENT > MAX(LEFT-SUBTREE) AND PARENT < MIN(RIGHT-SUBTREE)

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

		if(root==null){
			root = new Node(value);
			return;
		}

		Node temp = root;
		Node prevTemp = null;
		while(temp!=null){

			prevTemp = temp;
			if(temp.value<value){
				temp = temp.right;
			}
			else {
				temp = temp.left;
			}
		}

		if(prevTemp.value>value){
			prevTemp.left = new Node(value);
		}
		else{
			prevTemp.right = new Node(value);
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

	int minValue(Node rightTree){
		int min = rightTree.value;
		Node temp = rightTree;
		while(temp!=null){
			min = temp.value;
			temp = temp.left;
		}
		return min;
	}

	int maxValue(Node leftTree){
		int max = leftTree.value;
		Node temp = leftTree;
		while(temp!=null){
			max = temp.value;
			temp = temp.right;
		}
		return max;
	}


	boolean isBST(Node node){

		if(node==null){
			return true;
		}

		if(node.left!=null && maxValue(node.left)>node.value){
			return false;
		}

		if(node.right!=null && minValue(node.right)<node.value){
			return false;
		}

		return isBST(node.left) && isBST(node.right);
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
    	if(bst.isBST(bst.root)){
    		System.out.println("yes");
    	}
    	else{
    		System.out.println("No");
    	}
	}
}