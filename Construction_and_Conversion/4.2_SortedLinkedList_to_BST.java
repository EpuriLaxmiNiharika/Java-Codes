import java.util.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class LinkedListNode{

	int value;
	LinkedListNode next;

	LinkedListNode(int value){

		this.value = value;
	}
}

class LinkedList {
 
    LinkedListNode head;
   	
   	void push(int new_data) {
        LinkedListNode new_node = new LinkedListNode(new_data);

        new_node.next = head;
 
        head = new_node;
    }

    void printList(LinkedListNode node) {
        while (node != null) 
        {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    Node construct_BST(int num_nodes){

		if(num_nodes<=0){
			return null;
		}

		Node left = construct_BST(num_nodes/2);
		Node root = new Node(head.value);
		head = head.next;
		root.left = left;
		Node right = construct_BST(num_nodes-num_nodes/2-1);
		root.right = right;

		return root;
	}


	int node_count(LinkedListNode head_lst){

		int count=0;
		while(head_lst!=null){
			count++;
			head_lst = head_lst.next;
		}
		return count;
	}

  }

class BST{

	Node root;

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
		
		LinkedList llist = new LinkedList();
 
        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
 
		
        BST bst = new BST();
		bst.root = llist.construct_BST(6);
		bst.morris_inorder();
	}
}