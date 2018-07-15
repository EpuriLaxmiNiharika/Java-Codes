import java.util.*;

class Node{
	int value;
	int min_till_now;
	Node(int value){
		this.value = value;
		min_till_now = Integer.MAX_VALUE;
	}
}


class CustomStack{

	Stack<Node> stack = new Stack<Node>();
	int size = 0;
	int min_till_now = Integer.MAX_VALUE;

	void addElement(int value){
		if(size==0){
			Node new_node = new Node(value);
			new_node.min_till_now = min_till_now;
			stack.push(new_node);
			min_till_now = value;
			size++;
			return;
		}
		
		if(value<min_till_now){
			min_till_now = value;
		}

		Node new_node = new Node(value);
		new_node.min_till_now = min_till_now;
		stack.push(new_node);
		size++;
	}


	void GetLastElement(){

		if(size==0){
			System.out.print("No elements in stack");
			return ;
		}
		System.out.println(stack.peek().value);
	}

	Node RemoveLastElement(){

		if(size==0){
			System.out.print("No elements in stack");
			return null;
		}

		Node popped = stack.pop();
		size--;
		System.out.println(""+popped.value);

		Node current_top = stack.peek();
		if(current_top.min_till_now > popped.min_till_now){ // update min till now
			min_till_now = current_top.min_till_now;
		}

		return popped;
	}


	int getMin(){

		if(size==0){
			System.out.print("No elements in stack");
			return -1;
		}
		System.out.println(min_till_now);
		return min_till_now;
	}


	public static void main(String[] args) {
		CustomStack stack = new CustomStack();
		stack.addElement(1);
		stack.addElement(20);
		stack.addElement(5);
		stack.GetLastElement();
		stack.getMin();
		stack.RemoveLastElement();
		stack.addElement(4);
		stack.getMin();
	}
}

