import java.util.*;

class Node{

	int value;
	int min_till_now;

	Node(int value, int min_till_now){

		this.value = value;
		this.min_till_now = min_till_now;
	}
}

class CustomStack extends Stack<Node>{

	public void push(int value){

		if(super.isEmpty()){
			super.push(new Node(value,value));
			return;
		}

		Node top = super.peek();

		if(top.min_till_now<value){

			Node new_node = new Node(value,top.min_till_now);

			super.push(new_node);
		}

		else{

			Node new_node = new Node(value,value);

			super.push(new_node);
		}
	}

	public Node removeLast(){

		return super.pop();
	}

	public Node getLast(){
		return super.peek();
	}

	public int min(){
		return super.peek().min_till_now;
	}

	public static void main(String[] args) {
		
		CustomStack s= new CustomStack();
		s.push(7);
		s.push(3);
		System.out.println(s.min());
		s.push(1);
		System.out.println(s.removeLast().value);
		s.push(2);
		s.push(9);
		System.out.println(s.getLast().value);
		s.push(0);
		System.out.println(s.removeLast().value);
		s.push(11);
		System.out.println(s.min());
	}
}