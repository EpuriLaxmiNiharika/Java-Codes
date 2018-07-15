import java.util.*;

class ReverseStack{
	static Stack<Integer> s = new Stack<Integer>();

	static void reverseStack(){

		if(s.isEmpty()){
			return;
		}

		else{
			int ele = s.pop();
			reverseStack();
			insertAtbottom(ele);
		}
	}

	static void insertAtbottom(int x){ // here we are inserting x at bottom and there by pushing other elements to top by 1 each call to this func

		if(s.isEmpty()){
			s.push(x);

		}
		else{
			int a = s.pop();
			insertAtbottom(x);
			s.push(a);
		}
	}

	public static void main(String[] args) {
		
		s.push(10);
		s.push(20);
		s.push(30);

		for(Integer e: s){
			System.out.print(e+" ");
		}

		reverseStack();
		
		System.out.println();

		for(Integer e: s){
			System.out.print(e+" ");
		}
	}
}