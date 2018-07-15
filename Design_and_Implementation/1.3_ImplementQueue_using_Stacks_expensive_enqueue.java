/*

enQueue(q, x)
  1) While stack1 is not empty, push everything from satck1 to stack2.
  2) Push x to stack1 (assuming size of stacks is unlimited).
  3) Push everything back to stack1.

dnQueue(q)
  1) If stack1 is empty then error
  2) Pop an item from stack1 and return it

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
		if(stack1.isEmpty()){
			stack1.push(new Node(value));
			return;
		}

		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		stack1.push(new Node(value));

		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}
	

	public void dequeue(){ 
		if(stack1.isEmpty()){
			System.out.print(" Sorry no elements in Queue");
			return;
		}
		
		Node temp =stack1.pop();
		System.out.println("Popped ele: "+temp.value);

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