import java.util.*;
class Node{

	int value;
	int min_tillNow;

	Node(int value, int min_tillNow){
		this.value = value;
		this.min_tillNow = min_tillNow;
	}
}

class Stack{

	ArrayList<Node> stack;

	Stack(){
		stack = new ArrayList<Node>();
	}


	void push(int value){
		if(!stack.isEmpty()){
			Node top = stack.get(stack.size()-1);
		//	System.out.println("top min : "+top.min_tillNow+"-- value: "+value);
			if(value < top.min_tillNow){
				Node new_node = new Node(value,value);
				stack.add(new_node);
			}
			else{
				Node new_node = new Node(value,top.min_tillNow);
				stack.add(new_node);

			}
		/*	for (Iterator<Node> i = stack.iterator(); i.hasNext();) {
			    Node item = i.next();
			    System.out.println(item.min_tillNow);
			}
		*/

		}
		else{
		//	System.out.println("top min empty: "+value);
			stack.add(new Node(value,value));
		}
	}


	int getMin(){
		if(stack.size()==0) return -1;
		int min = stack.get(stack.size()-1).min_tillNow;
		System.out.println("min till now: "+min);
		return min;
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(10);
		st.push(20);
		st.push(6);
		st.push(5);
		st.push(13);
		st.getMin();
	}

}