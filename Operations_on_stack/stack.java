import java.util.*;

class ReverseStack{

	static void reverse(Stack<Integer> s){

		Stack<Integer> temp_stack = new Stack<Integer>();

		temp_stack.push(s.pop());

		while (!s.isEmpty()) {
			
			int pop = s.pop();

			while(!temp_stack.isEmpty() && pop<temp_stack.peek()){

				s.push(temp_stack.pop());
			}

			temp_stack.push(pop);
		}

		for(int e:temp_stack){
			System.out.print(e+" ");
		}
	}


	static void addToBottom(Stack<Integer> s, int value){

		if(s.isEmpty() || s.peek()<value){
			s.push(value);
			return;
		}

		int top = s.pop();
		addToBottom(s,value);
		s.push(top);
	}

	public static void main(String[] args) {
		
		Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

		
		reverse(input);
	}
}