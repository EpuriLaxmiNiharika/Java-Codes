import java.util.*;


class Queue{

	Deque deque = new LinkedList<Integer>();

	void enqueue(int value){

		deque.add(value);
	}

	int dequeue(){

		if(!deque.isEmpty()){
			int value = (Integer)deque.removeFirst();
			System.out.println(value);
			return value;
		}

		return -1;
	}
}


class Stack{


	Deque deque = new LinkedList<Integer>();

	void push(int value){

		deque.add(value);
	}

	int pop(){

		if(!deque.isEmpty()){
			int value = (Integer)deque.removeLast();
			System.out.println(value);
			return value;
		}

		return -1;
	}
}


class Main{

	public static void main(String[] args) {
		Queue queue =new Queue();
		Stack stack =new Stack();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.dequeue();
		stack.push(10);
		stack.push(20);
		stack.pop();
	}
	
}
