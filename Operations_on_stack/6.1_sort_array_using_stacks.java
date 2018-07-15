import java.util.*;

class SortArray{

	static void sort_array(int[] arr){

		Stack<Integer> stack = new Stack<Integer>();

		for(int i = 0; i<arr.length;i++){

			stack.push(arr[i]);
		}

		// now sort stack

		sort_stack(stack);

		int i = 0;
		while (!stack.isEmpty()) {
			
			arr[i] = stack.pop();
			i++;
		}

		for(int e: arr){
			System.out.print(e+" ");
		}
	}


	static void sort_stack(Stack<Integer> stack){

		if(stack.isEmpty()){
			return;
		}

		int popped = stack.pop();
		sort_stack(stack);
		sort_stack_util(stack,popped);
	}

	static void sort_stack_util(Stack<Integer> stack,int value){

		if(stack.isEmpty() || stack.peek()>value){

			stack.push(value);
		}

		else{

			int popped = stack.pop();
			sort_stack_util(stack,value);
			stack.push(popped);
		}
	}

	public static void main(String[] args) {
		
		int[] arr = { 8, 5, 7, 1, 9, 12, 10};

		sort_array(arr);
	}

}