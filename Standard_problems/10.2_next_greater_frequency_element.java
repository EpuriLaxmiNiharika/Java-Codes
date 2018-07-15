// traverse from left of the array. 
// Idea is somewhat similar to stock span problem and next greater eleemnt prob

import java.util.*;

class NextGreaterFreqElement{

	static void next_greater_freq_ele(int[] arr){

		HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();

		for(int i  = 0; i<arr.length;i++){

			if(freq.get(arr[i])==null){
				freq.put(arr[i],1);
			}
			else{
				int frq = freq.get(arr[i]);
				freq.put(arr[i],frq+1);
			}
		}


		Stack<Integer>stack = new Stack<Integer>();
		stack.push(0);
	
		for(int i = 1;i<=arr.length-1;i++){

			int top = stack.peek();
			while (!stack.isEmpty() && freq.get(arr[i])>freq.get(arr[top])) {
				System.out.println(arr[top]+"--->"+arr[i]);

				stack.pop();

				if(stack.isEmpty()){
					break;
				}
				top = stack.peek();
			}

			stack.push(i);
		}

		for(int e:stack){
			System.out.println(arr[e]+"--->"+(-1));
		}
	}

	public static void main(String[] args) {
		
		 int arr[]= {1, 1, 2, 3, 4, 2, 1};
		 next_greater_freq_ele(arr);	
	}
}