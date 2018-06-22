/* 

	IF INORDER TRAVERSAL IS IN ASCENDING ORDER THEN BST... ELSE NOT

	CHECK THIS WHILE DOING INORDER TRAVERSAL

*/
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



	void isBST(){

		morrisInorder();
	}


	void morrisInorder(){
		Node prev = null;
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
					// System.out.print(current.value+" ");
					if(prev!=null){
						if(prev.value>current.value){
							System.out.println("NO");
							return;
						}
					}
					prev = current;	
					inorder_pred.right = null;
					current = current.right;
				}
			}

			else{
				// System.out.print(current.value+" ");
			
				if(prev!=null){
					if(prev.value>current.value){
						System.out.println("NO");
						return;
					}
				}
				prev = current;
				current = current.right;
			}
		}
		System.out.println("yes");
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
    	bst.isBST();
	}
}