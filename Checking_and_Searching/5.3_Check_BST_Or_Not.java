/* 

	IF INORDER TRAVERSAL IS IN ASCENDING ORDER THEN BST... ELSE NOT

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



	boolean isBST(Node node){

		ArrayList<Integer> lst  =  new ArrayList<Integer>();

		morrisInorder(lst);

		for(int i = 0; i<lst.size()-1;i++){
			if(lst.get(i+1)<lst.get(i)){
				return false;
			}
		}	
		return true;
	}


	void morrisInorder(ArrayList<Integer> arr){
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
					arr.add(current.value);
					inorder_pred.right = null;
					current = current.right;
				}
			}

			else{
				// System.out.print(current.value+" ");
				arr.add(current.value);
				current = current.right;
			}
		}
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