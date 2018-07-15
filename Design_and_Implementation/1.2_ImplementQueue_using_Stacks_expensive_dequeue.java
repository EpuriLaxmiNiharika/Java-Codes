/*

In this method, in en-queue operation, the new element is entered at the top of stack1. 
In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.

enQueue(q,  x)
  1) Push x to stack1 (assuming size of stacks is unlimited).

deQueue(q)
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it.

*/


import java.util.Stack;

class Node{
	
	int value;

	public Node(int value){
		this.value = value;
	}
}

class Queue{

	Stack<Node> stack1;
	Stack<Node>  stack2;

	Queue(){
		stack1 = new Stack<Node>();
		stack2 = new Stack<Node>();
	}


	public void enqueue(int value){ 
		stack1.push(new Node(value));
	}
	

	public void dequeue(){ 
		if(stack1.isEmpty() && stack2.isEmpty()){
			System.out.print(" Sorry no elements in Queue");
			return;
		}
		
		if(stack2.isEmpty()){
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		Node temp = stack2.pop();
		System.out.println("Popped element: "+temp.value);

	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(40);
		queue.enqueue(50);
		queue.dequeue();
		queue.enqueue(60);
	}
	
}