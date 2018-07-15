import java.util.Stack;

class FindMinEle{
	int min =0;
	Stack<Integer> stack = new Stack<Integer>();

	void push(int ele){

	//	System.out.println("ele "+ele +" min "+min);
		if(stack.isEmpty()){
			min = ele;
			stack.push(ele);
			return;
		}

		if(ele>min){ // min = 7;
			stack.push(min - ele);
		}

		else{
			stack.push(min);
			min = ele;
		}

		
	}


	int pop(){
		int popped = stack.pop();

		if(popped<0){
			System.out.println("popped "+(min-popped));
			return min - popped;
		}
		else{
			System.out.println("popped "+min);
			min = popped;
			return min;
		}
		

	}

	int min(){
		System.out.println("min Ele: "+min);
		return min;
	}

	public static void main(String[] args) {
		FindMinEle find = new FindMinEle();
		find.push(7);
		find.push(8);
		find.push(4);
		find.push(2);
		find.push(3);
		find.push(5);
		find.push(1);
	/*	find.stack.forEach(k->{
    			System.out.print(" "+k +" ");
			});
	*/		
		find.min();
		find.pop();
		find.min();
		find.pop();
		find.pop();
		find.min();
		find.pop();
		find.pop();
		find.min();
	}

}