class Node{
	Node prev;
	Node next;
	int value;
	Node(int value){
		this.value = value;
		next = prev = null;
	}
}


class Stack{

	Node top;
	Node middle;
	int size;

	Stack(){
		top = middle = null;
		size = 0;
	}

	Node top(){
		return top;
	}

	void push(int element){

		if(size==0){
			size++;
			top = new Node(element);
			middle = top;
			return;
		}

		if(size%2==0){
			middle = middle.next;
		}

		size++;

		Node new_node = new Node(element);
		top.next = new_node;
		new_node.prev = top;
		top = new_node;
	}

	Node pop(){

		if(size==0){
			System.out.println("No elements in Stack");
			return null;
		}

		
		if(size%2==1){
			middle = middle.prev;
			Node top_temp = top;
			top = top.prev;
			size--;
			return top_temp;
		}

		size--;
		Node top_temp = top;
		top = top.prev;
		return top_temp;
	}


	Node getMiddle(){
		return middle;
	}

	Node removeMiddle(){
		if(middle==null){
			return null;
		}

		if(size==1){
			return pop();
		}

		middle.prev.next = middle.next;
		middle.next.prev = middle.prev;
		
		size--;

		return middle;
	}


	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push(11);
        stack.push( 22);
        stack.push( 33);
        stack.push( 44);
        stack.push( 55);
        stack.push( 66);
        stack.push( 77);
        System.out.println("popped: "+stack.pop().value);
        System.out.println("middle: "+stack.getMiddle().value);
	}

}