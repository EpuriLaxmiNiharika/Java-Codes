import java.util.*;

class DeleteElements{

	static void customDelete(int[] arr, int count){

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(0);

		int counter = 0;
		for(int i = 1; i<arr.length;i++){

			int ele = arr[i];

			while (!stack.isEmpty() && stack.peek()<ele && counter<count) {
				
				stack.pop();
				counter++;
			}

			stack.push(ele);
		}

		if(counter==count){

			for(int e: stack){
				System.out.print(e+" ");
			}
		}
	}

	public static void main(String[] args) {
	
		int arr[] = { 23, 45, 11, 77, 18};
		customDelete(arr,3);	
	}

}