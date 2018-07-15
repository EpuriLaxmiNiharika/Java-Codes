
class Node{
	int value;
	int priority;
	Node next;
	Node prev;
	Node(int value, int priority){
		this.value = value;
		this.priority = priority;
		prev = null;
		next = null;

	}
}

class PriorityQueue{ // put elements in stack in decreasing order of priority

	Node front,rear;
	int size;

	PriorityQueue(){
		front = rear = null;
		size =0;
	}

	void enqueue(int ele, int priority){

		if(size==0){
			front = rear = new Node(ele,priority);
			size++;
			return;
		}


		if(priority>front.priority){
			Node new_node = new Node(ele,priority);
			front.next = new_node;
			new_node.prev = front;
			front = new_node;
			size++;
			return;
		}


		else if(priority<rear.priority){
			Node new_node = new Node(ele,priority);
			new_node.next = rear;
			rear.prev = new_node;
			rear = new_node;
			size++;
			return;
		}


		Node new_node = new Node(ele,priority);
		Node temp = rear;

		while (temp!=null) {
			if(temp.priority >= priority){
				break;
			}
			temp = temp.next;
		}
		
		temp.prev.next = new_node;
		new_node.prev = temp.prev;
		new_node.next = temp;
		temp.prev = new_node;
		size++;

	}

	public void dequeue(){
		if(size == 0){
			System.out.println("No elements in queue");
		}
		else{
			Node temp = front;
			front = front.prev;
			front.next = null;
			System.out.print("dequeued "+temp.value);
			size--;
		}
	}

	void printQueue(){
		Node temp = rear;
		while(temp!=null){
			System.out.println(temp.value+"--"+temp.priority);
			temp = temp.next;
		}

		System.out.print("\n");
	}


	public static void main(String[] args) {
		PriorityQueue prior = new PriorityQueue();
		prior.enqueue(1,1);
		prior.enqueue(3,3);
		prior.enqueue(2,2);
		prior.enqueue(5,5);
		prior.enqueue(4,4);
		prior.printQueue();
	}
}