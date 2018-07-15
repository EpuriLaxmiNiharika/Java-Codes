import java.util.*;

class SortStack{
	static Stack<Integer> s = new Stack<Integer>();

	static void sortstack(){

		if(s.isEmpty()){

		}

		else{
			int ele = s.pop();
			sortstack();
			sortStackUtil(ele);
		}
	}

	static void sortStackUtil(int x){ // whenever we are visiting this func with new ele.. stack is prev sorted. Now we are just inserting new ele to sorted stack. So we need to find correct position of the new ele

		if(s.isEmpty() || x>s.peek()){
			s.push(x);
		}

		else{
			int top = s.pop();
			sortStackUtil(x);
			s.push(top);
		}	

	}

	public static void main(String[] args) {
		
		s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
      

		for(Integer e: s){
			System.out.print(e+" ");
		}

		sortstack();
		
		System.out.println();

		for(Integer e: s){
			System.out.print(e+" ");
		}
	}
}