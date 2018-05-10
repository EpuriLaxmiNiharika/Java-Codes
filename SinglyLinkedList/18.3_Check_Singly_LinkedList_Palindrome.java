/*
A simple solution is to use a stack of list nodes. This mainly involves three steps.
1) Traverse the given list from head to half of the list and those nodes to stack.

If the linkedlist has even number of elements
	2)  while traversing remaining half of the list, pop the node from stack and compare. If both the nodes are equal then continue traversing.
	If both the nodes are not equal => LINKED LIST IS NOT PALINDROME

If the linked list has odd number of elements.
	Repeat the above process except push only first n/2 elements from stack and then compare then with elements from n/2+1 (middle +1)th node

Time complexity of above method is O(n), but it requires O(n) extra space.

*/


import java.util.Stack;

class Node{
    String data;
    Node next;
    Node(String d){ 
        data = d;  
        next = null; 
    }
}
 
// Linked List class
class LinkedList{
    Node head;  // head of list
 	int size;
    /* Inserts a new Node at front of the list. */
    public void push(String new_data)
    {
         Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
        size++;
    }

    
    public void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
         System.out.print("\n");
    }


    void checkPalindrome_List(){

    	if(size == 0) return;

    	if(size == 1) {
    		System.out.println("LinkedList is PALINDROME");
    		return;
    	}

    	int count = 1;
    	Node temp = head;
    	Stack<String> stack = new Stack<String>();

    	if(size%2==0){ // even number of elements in Linked list
	    	while (count<=size/2) {
	    		stack.push(temp.data);
	    		temp = temp.next;
	    		count++;
	    	}

	    	while (temp!=null) {
	    		String top_stack = stack.pop();
	    		String temp_str = temp.data;
	    		if(!top_stack.equals(temp_str)){
	    			System.out.println("Not PALINDROME");

	    			return;
	    		}
	    		temp = temp.next;
	    	}

	    	if(temp==null){
	    		System.out.println("PALINDROME");
	    		return;
	    	}
	    }
	   else{
	   		while (count<=(size/2)) { // 1 - middle -1
	    		stack.push(temp.data);
	    		temp = temp.next;
	    		count++;
	    	}

	    	temp = temp.next;
	   
	    	while (temp!=null) {
	    		String top_stack = stack.pop();
	    		String temp_str = temp.data;
	    		if(!top_stack.equals(temp_str)){
	    			System.out.println("Not PALINDROME");

	    			return;
	    		}
	    		temp = temp.next;
	    	}

	    	if(temp==null){
	    		System.out.println("PALINDROME");
	    		return;
	    	}

	   }
    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list1 = new LinkedList();

        list1.push("R");
        list1.push("A");
        list1.push("D");
        list1.push("A");
        list1.push("R"); // R M D P R
        list1.checkPalindrome_List();

    }
}