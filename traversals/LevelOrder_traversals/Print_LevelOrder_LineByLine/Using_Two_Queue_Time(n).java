class Node{
	Node leftChild;
	Node rightChild;
	Node prev;
	Node next;
	int value;
	public Node(int value){
		this.value = value;
		leftChild = rightChild = prev = next = null;
	}
}

class Queue{
	Node front;
	Node rear;
	int size;

	public Queue(){
		size =0;
		front = rear = null;
	}
	public void enqueue(Node node){
		if(isEmpty()){
			front =node;
			rear = node;
			size ++;
			return;
		}
		rear.prev = node;
		node.next = rear;
		rear = node;
		size++;
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

	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
}


class BinaryTree{

	Queue queue1; // holds current level or next level nodes
	Queue queue2; // holds next level nodes or current level nodes
	Node root;

	BinaryTree(){
		root = null;
		queue1 = new Queue();
		queue2 = new Queue();
	}

	void printLevelWise(){
		queue1.enqueue(root);
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			while(!queue1.isEmpty()){
				Node temp = queue1.dequeue();
				System.out.print(" "+temp.value);
				if(temp.leftChild!=null){
					queue2.enqueue(temp.leftChild);
				}
				if(temp.rightChild!=null){
					queue2.enqueue(temp.rightChild);
				}
			}
			System.out.println();

			while(!queue2.isEmpty()){
				Node temp = queue2.dequeue();
				System.out.print(" "+temp.value);
				if(temp.leftChild!=null){
					queue1.enqueue(temp.leftChild);
				}
				if(temp.rightChild!=null){
					queue1.enqueue(temp.rightChild);
				}
			}

			if(!queue1.isEmpty()){
				System.out.println();
			}	
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
        tree.root.rightChild.rightChild = new Node(6);
        tree.printLevelWise();
	}
}
