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
 
    /* head node of link list */
    LinkedListNode head;
   	
   	void push(int new_data) {
        /* allocate node */
        LinkedListNode new_node = new LinkedListNode(new_data);
 
        /* since we are adding at the begining,
           prev is always NULL */
        // new_node.prev = null;
 
        /* link the old list off the new node */
        new_node.next = head;
 
        /* change prev of head node to new node */
        // if (head != null)
        //     head.prev = new_node;
 
        /* move the head to point to the new node */
        head = new_node;
    }

    void printList(LinkedListNode node) {
        while (node != null) 
        {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

  }

class BST{

	Node root;


	Node construct_BST(LinkedListNode start_node){

		if(start_node==null){
			return null;
		}

		LinkedListNode right_start = null;
		LinkedListNode temp = null;
		int count_nodes = node_count(start_node);
		Node root_node = null;

		if(count_nodes>1){
			temp = getPrevMiddle(start_node,count_nodes);

			root_node = new Node(temp.next.value);
			right_start = temp.next.next;

			temp.next = null;
			root_node.left = construct_BST(start_node);
			root_node.right = construct_BST(right_start);
		}
		else{
			root_node = new Node(start_node.value);
		}

		return root_node;
	}


	int node_count(LinkedListNode head_lst){

		int count=0;
		while(head_lst!=null){
			count++;
			head_lst = head_lst.next;
		}
		return count;
	}

	LinkedListNode getPrevMiddle(LinkedListNode node, int count){

		LinkedListNode temp = node;

		int mid = count/2 -1;

		while(mid!=0 && temp!=null){

			temp=temp.next;
			mid--;
		}

		return temp;
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
		bst.root = bst.construct_BST(llist.head);
		bst.morris_inorder();
	}
}