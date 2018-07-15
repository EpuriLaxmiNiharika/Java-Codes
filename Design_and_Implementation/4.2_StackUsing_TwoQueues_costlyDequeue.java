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
		front = null;
		rear = null;
		size = 0;
	}

	void enqueue(Node new_node){
		if(size==0){
			front = rear = new_node;
			size++;
			return;
		}

		if(size ==1){
			size++;
			new_node.next = front;
			front.prev = new_node;
			front = new_node;
			rear.prev = front;
			front.next = rear;
			return;
		}

		new_node.next = front;
		front.prev = new_node;
		front = new_node;
		size++;
	}


	Node dequeue(){
	//	System.out.println("size"+size);

		if(size>1){
			Node Last_prev = rear.prev;
			Last_prev.next = null;
			Node temp = rear;
			rear = Last_prev;
			size--;
			return temp;
		}

		else if(size ==1){
			size--;
			Node temp = front;
			rear = front = null;
			return temp;
		}
		
		else{
			System.out.println("Empty Queue");
			return null;
		}
	}

	boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
}

class Stack{
	Queue queue1,queue2;

	Stack(){
		queue1 = new Queue();
		queue2 = new Queue();
	}

	public void push(int ele){
	
	// costly dequeue
		queue1.enqueue(new Node(ele));

	}


	public int pop(){

		if(queue1.size==0){
			System.out.println("No elements in Queue");
			return -1;
		}

		while (queue1.size>1) {
			queue2.enqueue(queue1.dequeue());
		}

		Node top = queue1.dequeue();

		while(!queue2.isEmpty()){
			queue1.enqueue(queue2.dequeue());
		}
		return top.value;
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
   		s.push(2);
    	s.push(3);
    	System.out.println("dequeued: "+s.pop());
    	System.out.println("dequeued: "+s.pop());
    	s.push(4);
    	System.out.println("dequeued: "+s.pop());
	}

}