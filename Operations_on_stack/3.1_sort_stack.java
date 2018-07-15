import java.util.*;

class SortStack{

	static void sortstack(Stack<Integer> s){

		for(Integer e: s){
			System.out.print(e+" ");
		}

		Stack<Integer> temp = new Stack<Integer>();

		while (!s.isEmpty()) {
			
			int popped = s.pop();

			if(temp==null){
				temp.push(popped);
			}
			else{

				while(!temp.isEmpty() && temp.peek()>popped){

					s.push(temp.pop());
				}

				temp.push(popped);
			}
		}

		System.out.println();

		for(Integer e: temp){
			System.out.print(e+" ");
		}
		
	}


	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();

		s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

		sortstack(s);		
	}
}