import java.util.*;

class ReverseStack{

	static void reverseStack(Stack<Integer> s){

		for(Integer e: s){
			System.out.print(e+" ");
		}


		Stack<Integer> temp = new Stack<Integer>();

		while (!s.isEmpty()) {
			
			temp.push(s.pop());
		}

		System.out.println();

		for(Integer e:temp){
			System.out.print(e+" ");
		}
	}

	

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(20);
		s.push(30);

		reverseStack(s);
		
		
	}
}