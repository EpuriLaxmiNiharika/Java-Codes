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

	void isSubsequence(int[] arr){

		ArrayList<Integer> inorder = new ArrayList<Integer>();
		inorderTraversal(inorder);

		// printArrayList(inorder);
		int inorder_ptr = 0;
		int arr_ptr = 0;

		while(arr_ptr!=arr.length && inorder_ptr!=inorder.size()){

			if(inorder.get(inorder_ptr)==arr[arr_ptr]){
				arr_ptr ++;
				inorder_ptr++;
			}
			else if(inorder.get(inorder_ptr)<arr[arr_ptr]){
				inorder_ptr++;
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		if(arr_ptr==arr.length){
			System.out.println("yes");
		}

	}

	void inorderTraversal(ArrayList<Integer> inorder){

		Node current = root;

		while (current!=null) {
			
			if(current.left==null){

				inorder.add(current.value);
				current = current.right;
			}

			else{
				Node prev = current.left;
				while (prev.right!=null && prev.right!=current) {
					prev = prev.right;
				}

				if(prev.right==null){
					prev.right = current;
					//System.out.print(current.value+" ");
					current = current.left;
				}

				else{
					prev.right = null;
			//		System.out.print(current.value+" ");
					inorder.add(current.value);
					current = current.right;
				}
			}
		}
		
	}

	void printArrayList(ArrayList<Integer> lst){
		System.out.println();
		for(int e:lst){
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	void insert(int value){

		if(root==null){
			root = new Node(value);
			return;
		}

		Node temp = root;
		Node prev_temp = null;

		while (temp!=null) {
			prev_temp = temp;

			if(value<temp.value){
				temp = temp.left;
			}

			else{
				temp = temp.right;
			}
		}

		if(prev_temp.value<value){
			prev_temp.right = new Node(value);
		}

		else{
			prev_temp.left = new Node(value);
		}
	}

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.insert(8);
    	bst.insert(10);
    	bst.insert(3);
    	bst.insert(6);
    	bst.insert(1);
    	bst.insert(4);
    	bst.insert(7);
    	bst.insert(14);
    	bst.insert(13);
    	int seq[] = {4, 6, 7, 14};
    	bst.isSubsequence(seq);
	}
}