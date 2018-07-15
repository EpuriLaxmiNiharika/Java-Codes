 /*
 push(val): 
	if(val<min) {
		stack.push(val-min); // push the diff between val and min . THis is done to restore the next min
		min = val;
	}
	stack.push(val)

pop(){
	popped = stack.pop();
	if(popped==min){
	 	if(stack.isEmpty()){ //popped the only ele present in stack
	 		min =0;
	 	}
	 	else{
	 		int neg = stack.pop()
	 		min = min - neg;//holds next neg
	 	}
	}
}
*/

import java.util.Stack;

class FindMinEle{
	int min =0;

	Stack<Integer> stack = new Stack<Integer>();

	void push(int ele){

		if(stack.isEmpty()){
			min = ele;
			stack.push(ele);
			return;
		}

		else{
			if(ele<min){ // min = 7;
				stack.push(ele-min);
				min = ele;
			}
			stack.push(ele);
		}
	}


	int pop(){

		if(stack.isEmpty()){
			System.out.println("empty");
			return -1;
		}

		int popped = stack.pop();
		if(popped==min){
			
			if(stack.isEmpty()){ // only one element was there before in stack
				min = 0;
			}
			else{
				int neg = stack.pop();
				min  = popped-neg;
			}
		}

		System.out.println("popped "+popped);
		return popped;
	}

	int min(){
		System.out.println("min Ele: "+min);
		return min;
	}

	void peek(){

		if(stack.isEmpty()){
			System.out.println("empty");
			return;
		}
		System.out.println("top: "+stack.peek());
	}

	public static void main(String[] args) {
		FindMinEle s = new FindMinEle();
		// find.push(7);
		// find.push(8);
		// find.push(4);
		// find.push(2);
		// find.push(3);
		// find.push(5);
		// find.push(1);
		// find.stack.forEach(k->{
  //   			System.out.print(" "+k +" ");
		// 	});
			
		// find.min();
		// find.pop();
		// find.min();
		// find.pop();
		// find.pop();
		// find.min();
		// find.pop();
		// find.pop();
		// find.min();

		s.push(19);
	    s.push(10);
	    s.push(9);
	     s.min();
	    s.push(8);
	     s.min();
	     s.push(7);
	      s.min();
	      s.push(6);
	    s.min();
    	s.pop();
    	 s.min();
    	s.pop();
    	 s.min();
    	s.pop();
    	 s.min();
    	s.pop();
    	 s.min();
    	s.pop();
    	s.min();
	}

}