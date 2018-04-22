class Node{
	int value;
	Node leftChild;
	Node rightChild;
	Node next;
	Node prev;
	public Node(int value){
		this.value = value;
		leftChild = rightChild = next = prev = null;
	}
}

class Queue{
	Node front;
	Node rear;
	int size;
	public Queue(){
		front  = rear = null;
		size = 0;
	}

	public void enqueue(Node node){

		if(front == null){
			front = rear = node;
			size ++;
			return;
		}
		rear.prev = node;
		node.next = rear;
		rear = node;
		size ++;
	}

	public Node dequeue(){
		if(size==0){
			System.out.print(" no elements in queue");
			return null;
		}

		if(size == 1){
			Node temp = front;
			front = null;
			rear = null;
			size --;
			return temp;	
		}

		Node temp = front;
		front = front.prev;
		front.next = null;
		size --;
		return temp; 
	}
}

class LevelOrder{
	Node root;
	Queue queue;
	LevelOrder(){
		queue = new Queue();
	}

	void printLevelWise(){
		queue.enqueue(root);
		while (true) {
			int num_deques = queue.size;
			if(num_deques ==0){ // no ele in queue => all levels are visited
				break;
			}
			while(num_deques>0){ // print nodes of a particular level
				Node temp = queue.dequeue();
				if(temp!=null){
					System.out.print(" "+temp.value);
					num_deques--;
					if(temp.leftChild!=null){
						queue.enqueue(temp.leftChild);
					}
					if(temp.rightChild!=null){
						queue.enqueue(temp.rightChild);
					}
				}
				else{
					break;
				}
			}
			System.out.print("\n");
		}	
	}

	public static void main(String[] args) {
		LevelOrder tree = new LevelOrder();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.rightChild = new Node(6);
       	tree.printLevelWise();
	}
}