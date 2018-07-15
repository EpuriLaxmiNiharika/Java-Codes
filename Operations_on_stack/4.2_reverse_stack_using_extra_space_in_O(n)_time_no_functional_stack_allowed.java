/*
	We can reverse a string in O(1) time if we internally represent the stack as inked list. 
	Reverse a stack would require a reversing a linked list which can be done with O(n) time and O(1) extra space.

*/

import java.util.*;

class StackNode{

	int value;
	StackNode next;

	StackNode(int value){
		this.value = value;
	}
}


class Stack{

	StackNode top;

	void push(int value){

		StackNode new_node = new StackNode(value);
		new_node.next = top;
		top = new_node;
	}

	void pop(){

		if(top==null){
			System.out.println("empty");
		}

		else{
			System.out.println(top.value);
			top = top.next;
		}
	}

	void reverseStack(){

		StackNode temp = top;

		StackNode prev = null;

		printStack();

		while (temp!=null) {

			StackNode next_temp = temp.next;
			temp.next = prev;
			prev = temp;	
			temp = next_temp;
		}

		top = prev;

		printStack();
	}

	void printStack(){

		StackNode temp = top;

		while(temp!=null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}

		System.out.println();
	}
	

	public static void main(String[] args) {
		
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);

		s.reverseStack();
		
		
	}
}