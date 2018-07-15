

class Node implements Cloneable{

	int value;
	Node next;
	Node prev;
	Node(int value){
		this.value = value;
		next = null;
		prev = null;
	}

	public Object clone(){
		try{  
			return (Node)super.clone();
		}  
		catch(Exception e){
			System.out.println(" "+e.getMessage());
		}
		return null;
	}
}

class Stack{

	Node top;
	Node bottom;
	int size;

	Stack(){
		top = null;
		bottom = null;
		size = 0;
	}

	void push(Node new_node){
	
		if(size==0){
			top = bottom = new_node;
			size++;
			return;
		}

		top.prev = new_node;
		new_node.next = top;
		top = new_node;
		size++;
	}

	Node pop(){
		if(size==0){
			System.out.println("No ele in stack");
			return null;
		}

		if(size == 1){
			Node temp = top;
			top = null;
			size--;
			return temp;
		}
		size--;
		Node temp = top;
		top = top.next;
		top.prev = null;
		return temp;
	}

	boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
}
class MergeStacks{


	Stack stack1;
	Stack stack2;
	Stack stack3;

	MergeStacks(Stack stack1, Stack stack2){
		this.stack1 = new Stack();
		this.stack2 = new Stack();
		this.stack1 = stack1;
		this.stack2 = stack2;
		stack3 = new Stack();
	}


	void push(Stack stack, int value){
		stack.push(new Node(value));
	}

	Node pop(Stack stack){
		return stack.pop();
	}

	void mergeStacks(){

		int count = 0;
		Node temp = stack1.bottom;
		while(count!=stack1.size){
			count++;
			stack3.push(temp);
			temp = temp.prev;
		}
		count = 0;
		temp = stack2.bottom;

		while(count!=stack2.size){
			count++;
			stack3.push(temp);
			temp = temp.prev;
		}

		printStack(stack3);

	}


	void printStack(Stack s){
		Node temp = s.top;
		while(temp!=null){
			System.out.print(" "+temp.value);
			temp = temp.next;
		}
		System.out.println(" ");
	}

}

class Main{

	public static void main(String[] args) {
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push(new Node(1));
		stack1.push(new Node(2));
		stack1.push(new Node(3));

		stack2.push(new Node(4));
		stack2.push(new Node(5));
		stack2.push(new Node(6));
		//Node temp1 = stack2.pop();
		//System.out.println(" "+temp1.value);
		MergeStacks merge = new MergeStacks(stack1,stack2);
		merge.mergeStacks();
	}
}