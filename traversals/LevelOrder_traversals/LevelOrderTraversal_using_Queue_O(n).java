class Node{
	int value;
	Node left;
	Node right;
	Node next;
	Node prev;
	public Node(int value){
		this.value = value;
		left = null;
		right = null;
		next = prev = null;
	}
}

class Queue{
	int size ;
	Node front;
	Node rear;
	public Queue(){
		front =rear = null;
		size = 0;
	}

	public void enqueue(Node new_node){
		if(front ==null){
			front = rear = new_node;
			size ++;
			return;
		}
		else{
			size ++;
			rear.prev = new_node;
			new_node.next = rear;
			rear = new_node;
		}
	}


	public int size(){
		Node temp = rear;
		while(temp!=null){
			size ++;
			temp = temp.right;
		}
		return size;
	}
	public Node dequeue(){
		if(size ==1){
			Node temp =  front;
			front = rear = null;
			size --;
			return temp;
		}
		if(size>1){
			Node temp = front;
			front = front.prev;
			front.next = null;
			size --;
			return temp;
		}
		
		else{
			System.out.println("No elements in queue");
			return null;
		}
	}

	public boolean isEmpty(){
		if(front==null){
			return true;
		}
		return false;
	}

	public void printQueue(){
		Node temp = front;
		while(temp!=null){
			System.out.print(" "+ temp.value);
			temp = temp.prev;
		}
		System.out.println("\n");
	}
}

class Tree{
	Node root;
	Queue queue;
	public Tree(){
		queue = new Queue();
	}
	public void levelOrderTraversal(){
		queue.enqueue(root);
		while(!queue.isEmpty()){
			Node temp = queue.dequeue();
			
			System.out.print(" "+temp.value);
					
			if(temp.left!=null){
				queue.enqueue(temp.left);
			}
			if(temp.right!=null){
				queue.enqueue(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		Tree tree  = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left= new Node(4);
       	tree.root.left.left.left= new Node(5);
	    tree.levelOrderTraversal();
	}
}