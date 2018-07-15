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


class Queue{

	Node front;
	Node rear;
	int size;

	Queue(){
		front = rear = null;
	}

	void enqueue(int value){
		if(size ==0){
			front = rear = new Node(value);
			size++;
			return ;
		}

		Node new_node = new Node(value);
		new_node.next = rear;
		rear.prev = new_node;
		rear = new_node;
		size++;
	}

	Node dequeue(){

		if(size==0){
			System.out.print("No elements in Stack" );
			return null;
		}

		if(size == 1){
			size--;
			Node temp = front;
			front = rear = null;
			return temp;
		}
		size--;
		Node temp = front;
		front.prev.next = null;
		front = front.prev;
		
		return temp;
	}


}

class Stack{

	Queue queue;

	Stack(){
		queue  = new Queue();
	}

	void push(int ele){
		Node new_node = new Node(ele);
		if(queue.size==0){
			queue.enqueue(ele);
			return;
		}

		queue.enqueue(ele);
		int size = queue.size;
		int count = 0;
		while (count<(size-1)){
			queue.enqueue(queue.dequeue().value);
			count++;
		}
	}

	Node pop(){
		Node temp = queue.dequeue();
		if(temp!=null){
			System.out.print(" "+temp.value);
		}
		return temp;
	}


	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		stack.push(4);
		stack.push(5);
		stack.pop();
	}

}