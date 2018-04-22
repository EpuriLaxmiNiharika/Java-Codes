import java.util.LinkedList;

class Node{

	Node left;
	Node right;
	Node next;
	int data;
	Node prev;

	Node(int data){
		left = null;
		right = null;
		prev = null;
		next = null; 
		this.data = data;
	}
}


class Queue{

	Node front;
	Node rear;

	Queue(){
		front = null;
		rear = null;
	}

	public void enqueue(Node node){
		if(front == null){
			rear = front = node;
		}

		else{
			node.next = rear;
			rear.prev = node;
			rear = node;
		}
	}

	public Node dequeue(){

		if(front==null){
			System.out.println("No ele");
			return null;
		}

		if(front==rear){
			Node temp = front;
			front = null;
			rear = null;
			return temp;
		}

		Node temp = front;
		front = front.prev;
		front.next = null;
		return temp;
	}

	int size(){
		int size = 0;
		Node temp = rear;
		while (temp!=null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

}

class Tree{
	Node root;

	public Tree(){
		root = null;
	}

	public void printLevelOrder_lineByLine(){
		Queue q = new Queue();
		q.enqueue(root);
		int count = q.size();
		while (q.size()!=0) {
			count = q.size();
			while (count>0) {
				Node temp = q.dequeue();
				System.out.print(" "+temp.data);
				count--;
				if(temp.left!=null){
					q.enqueue(temp.left);
				}
				if(temp.right!=null){
					q.enqueue(temp.right);
				}
			}
			System.out.println("");
		}

	}

	
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		tree.root = new Node(1); // tree is linkedlist here.
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);
 
        System.out.println("Level traversal of binary tree is ");
        tree.printLevelOrder_lineByLine();
	}
}