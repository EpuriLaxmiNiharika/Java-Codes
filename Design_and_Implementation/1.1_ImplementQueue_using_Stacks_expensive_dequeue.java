/*

In this method, in en-queue operation, the new element is entered at the top of stack1. 

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


	public void enqueue(int value){ // always pushing elements to stack1. Holds reverse of queue.
		stack1.push(new Node(value));
	}
	

	public void dequeue(){ // to perform dequeue, first pop all elements from stack1 to stack2. Then pop first element from stack2.
							// then pop all elements from stack2 to stack1;
		if(stack1.isEmpty()){
			System.out.print(" Sorry no elements in Queue");
			return;
		}
		
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		Node temp =stack2.pop();
		System.out.println("Popped ele: "+temp.value);

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}

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