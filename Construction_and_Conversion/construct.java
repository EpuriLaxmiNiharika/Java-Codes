import java.util.*;

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


	Node construct_BST(int[] preorder){

		Stack<Node> stack = new Stack<Node>();
		root = new Node(preorder[0]);
		stack.push(root);

		for(int i = 1; i<preorder.length;i++){

			Node temp = null;

			while(!stack.isEmpty() && stack.peek().value < preorder[i]){
				temp = stack.pop();
			}

			if(temp!=null){
				temp.right = new Node(preorder[i]);
				stack.push(temp.right);
			}

			else{
				temp = stack.peek();
				temp.left = new Node(preorder[i]);
				stack.push(temp.left);
			}
		}

		return root;
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
		bst.root = bst.construct_BST(preorder);
		bst.morris_inorder();
	}
}