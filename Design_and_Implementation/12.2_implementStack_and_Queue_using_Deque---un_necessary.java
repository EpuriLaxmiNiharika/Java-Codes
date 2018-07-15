import java.util.*;

class Node{
	int value;
	Node next;
	Node prev;

	Node(int value){
		this.value = value;
		next = null;
		prev = null;
	}
}

class Stack{

	Deque<Node> deque = new ArrayDeque<Node>();

	void push(int element){

		Node new_node = new Node(element);
		
		if(deque.isEmpty()){	
			deque.add(new_node);
		//	Node last_node = deque.getLast();
			//System.out.println("lastnode1: "+last_node.value);
			return;
		}

		Node last_node = deque.getLast();
		last_node.next = new_node;
		new_node.prev = last_node;
		deque.add(new_node);
		//System.out.println("lastnode: "+deque.getLast().value);

	}

	Node pop(){

		if(deque.isEmpty()){
			System.out.println("Empty Stack");
			return null;
		}
		else{
			Node last = deque.removeLast();
			
			if(deque.isEmpty()){
				System.out.println("popped: "+last.value);
				return last;
			}

			Node updated_last_node = deque.getLast();
			updated_last_node.next = null;
			System.out.println("popped: "+last.value);
			return last;
		}
	}
}


class Queue{

	Deque<Node> deque = new ArrayDeque<Node>();

	void enqueue(int element){

		Node new_node = new Node(element);
		
		if(deque.isEmpty()){	
			deque.add(new_node);
		//	Node last_node = deque.getLast();
			//System.out.println("lastnode1: "+last_node.value);
			return;
		}

		Node last_node = deque.getLast();
		last_node.next = new_node;
		new_node.prev = last_node;
		deque.add(new_node);
		//System.out.println("lastnode: "+deque.getLast().value);

	}

	Node dequeue(){

		if(deque.isEmpty()){
			System.out.println("Empty Queue");
			return null;
		}

		else{
			Node last = deque.removeFirst();
			
			if(deque.isEmpty()){
				System.out.println("dequeued: "+last.value);
				return last;
			}

			Node updated_last_node = deque.getLast();
			updated_last_node.next = null;
			System.out.println("dequeued: "+last.value);
			return last;
		}
	}
}



class Main{

	public static void main(String[] args) {
	
		Stack stack = new Stack();
		Queue queue = new Queue();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
	
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
	}

}
