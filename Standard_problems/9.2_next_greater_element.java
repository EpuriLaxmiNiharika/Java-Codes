// traverse from left of the array. 
// Idea is somewhat similar to stock span problem

import java.util.*;

class NextGreaterElement{

	static void next_greater_ele(int[] arr){

		Stack<Integer>stack = new Stack<Integer>();
		stack.push(arr[0]);	

		for(int i = 1;i<arr.length;i++){

			int next = arr[i];

			while (!stack.isEmpty() && next>stack.peek()) {
				
				System.out.println(stack.pop()+"--->"+next);
			}

			stack.push(next);
		}

		while(!stack.isEmpty()){
			System.out.println(stack.pop()+"--->"+"-1");
		}
	}

	public static void main(String[] args) {
		
		 int arr[]= {11, 13, 21, 3,18};
		 next_greater_ele(arr);	
	}
}