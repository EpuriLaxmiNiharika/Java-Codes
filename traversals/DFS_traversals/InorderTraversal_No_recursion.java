class Node{
	Node leftChild;
	Node rightChild;
	Node next;
	int value;

	public Node(int value){
		this.value = value;
		leftChild = rightChild = next = null;
	}
}


class Stack{

	Node top;

	Stack(){
		top = null;
	}

	public void push(Node node){

		if(isEmpty()){
			top = node;
			return;
		}

		node.next = top;
		top = node;
	}
	
	public Node pop(){

		if(isEmpty()){
			System.out.print("sorry stack is empty..");
			return null;
		}

		Node temp = top;
		top = top.next;
		return temp;
	}

	public boolean isEmpty(){
		if(top ==null){
			return  true;
		}
		return false;
	}

	public void printStack(){
		Node temp = top;
		while(temp!=null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.print("\n");
	}
}

class BinaryTree{

	Stack stack;
	Node root;

	BinaryTree(){
		stack = new Stack();
		root = null;
	}

	void inorderTraversal(){
		if(root==null){
			return;
		}

		Node node = root;
		while (node!=null) {
			stack.push(node);
			node = node.leftChild;
		}

		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.print(node.value+" ");
			if(node.rightChild!=null){
				node = node.rightChild;
				stack.push(node);
				node = node.leftChild;
				while(node!=null){
					stack.push(node);
					node = node.leftChild;
				}
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
		tree.inorderTraversal();
	}
}