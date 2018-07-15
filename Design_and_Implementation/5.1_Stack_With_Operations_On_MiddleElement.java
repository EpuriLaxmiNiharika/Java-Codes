class Node{

	int value;
	Node next;
	Node prev;

	Node(int value){
		this.value = value;
	}
}

class Stack{

	Node top;
	int size = 0;
	Node middle;

	void push(int ele){

		if(top==null){
			top = new Node(ele);
			middle = top;
			size++;
		}
		else{
			Node new_node = new Node(ele);
			top.next = new_node;
			new_node.prev = top;
			top = new_node;
			size++;

			if(size%2==1){

				middle = middle.next;
			}
			
		}
	}

	void remove_middle(){

	//	System.out.println(size);
		if(size==0){
			return;
		}

		if(size==1){
			middle = null;
			top = null;
			size--;
		}

		else if(size==2){
			System.out.println(middle.value);
			middle = middle.next;
			middle.prev = null;
			size--;
		}


		else if(size%2==0){
			Node next_middle = middle.next;
			Node before_middle = middle.prev;
			next_middle.prev = before_middle;
			before_middle.next = next_middle;
			middle = next_middle;
			size--;
		}
		else{
			Node next_middle = middle.next;
			Node before_middle = middle.prev;
			next_middle.prev = before_middle;
			before_middle.next = next_middle;
			middle = before_middle;
			size--;
		}

	}

	void pop(){

		if(size>0){

			if(size%2==1){

				middle = middle.prev;
			}
			System.out.println(top.value);
			top = top.prev;
		}

	}

	void getMiddle(){

		if(middle!=null){
			System.out.println(middle.value);
		}
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		// stack.push(30);
		// stack.push(40);
		// stack.push(50);
		// stack.push(60);
		// stack.pop();
		stack.getMiddle();
		stack.remove_middle();
		stack.remove_middle();
		// stack.getMiddle();
		// stack.remove_middle();
		// stack.getMiddle();
		// stack.remove_middle();
		// stack.getMiddle();
		// stack.remove_middle();
		// stack.remove_middle();
	}
}