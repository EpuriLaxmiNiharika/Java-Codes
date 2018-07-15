// traverse from rightside of the array. 
// Idea is somewhat similar to stock span problem

import java.util.*;

class NextGreaterElement{

	static void next_greater_ele(int[] arr){

		Stack<Integer>stack = new Stack<Integer>();
		stack.push(arr.length-1);
		int[] nge = new int[arr.length];
		nge[arr.length-1] = -1;

		for(int i = arr.length-2;i>=0;i--){

			while (!stack.isEmpty() && arr[i]>=arr[stack.peek()]) {
				stack.pop();
			}

			if(stack.isEmpty()){
				nge[i] = -1;
			}

			else{
				nge[i] = arr[stack.peek()];
			}

			stack.push(i);
		}

		for(int e:nge){
			System.out.print(e+" ");
		}
	}

	public static void main(String[] args) {
		
		 int arr[]= {11, 13, 21, 3};
		 next_greater_ele(arr);	
	}
}