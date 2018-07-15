import java.util.*;

class SortArray{

	static void isSortable(int[] arr){

		Stack<Integer> stack  = new Stack<Integer>();

		int[] sorted = new int[arr.length];

		int expected = 1;

		int iterator = 0;

		for(int i = 0; i<arr.length;i++){

			if(stack.isEmpty()){

				stack.push(arr[i]);
			}

			else{
				while(!stack.isEmpty() && stack.peek()==expected){
					sorted[iterator] = stack.pop();
					expected++;
					iterator++;
				}

				if(stack.isEmpty()){
					stack.push(arr[i]);
				}

				else{
					if(arr[i]>stack.peek()){

						System.out.println("no");
						return;
					}
					else{
						stack.push(arr[i]);	
					}
				}
			}
		}

		System.out.println("yes");
	}

	public static void main(String[] args) {
		 int A[] = { 4, 1, 2, 3 };
		 isSortable(A);
	}
}