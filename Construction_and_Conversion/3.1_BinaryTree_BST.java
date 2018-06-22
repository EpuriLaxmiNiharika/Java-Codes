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


	void construct_BST(){

		ArrayList<Integer> ar_lst = new ArrayList<Integer>();

		morris_inorder(ar_lst);

		Collections.sort(ar_lst);
		System.out.println();
		copy_values_morris_inorder(ar_lst);

	}

	void morris_inorder(ArrayList<Integer> nodes_val){

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
						nodes_val.add(current.value);
						current = current.right;
					}
				}

			else{
				nodes_val.add(current.value);
				System.out.print(current.value+" ");
				current = current.right;
			}
		}
	}

	void copy_values_morris_inorder(ArrayList<Integer> nodes_val){
		int index = 0;

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
						current.value = nodes_val.get(index);
						index++;
						System.out.print(current.value+" ");
						current = current.right;
					}
				}

			else{
				current.value = nodes_val.get(index);
				index++;
				System.out.print(current.value+" ");
				current = current.right;
			}
		}
	}

	public static void main(String[] args) {
		
		BST bst = new BST();

		Node root = new Node(10);
	    root.left = new Node(30);
	    root.right = new Node(15);
	    root.left.left = new Node(20);
	    root.right.right = new Node(5);
 
		bst.root = root;

		bst.construct_BST();
	}
}