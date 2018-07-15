import java.util.Stack;

class SpecialStack extends Stack<Integer>{

	Stack<Integer> min_stack;

	 SpecialStack(){
		 min_stack = new Stack<Integer>();
	}

	void push(int ele){
		if(isEmpty()){
			super.push(ele);
			min_stack.push(ele);
			return;
		}

		int top = min_stack.pop();
		min_stack.push(top);
		if(ele < top){
			min_stack.push(ele);
		}
	}

	public Integer pop(){
	
		Integer popped_ele = super.pop();
		int min = min_stack.pop();
		if(min!=popped_ele){
			min_stack.push(min);
		}
		return popped_ele;
	}

	int getMin(){
		if(isEmpty()){
			return -1;
		}
		int min = min_stack.pop();
		min_stack.push(min);
		return min;
	}

	public static void main(String[] args) {
		SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
	}
}