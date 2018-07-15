// traverse from rightside of the array. 
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
		stack.push(arr.length-1);
		int[] ngf = new int[arr.length];
		ngf[arr.length-1] = -1;

		for(int i = arr.length-2;i>=0;i--){

			while (!stack.isEmpty() && freq.get(arr[i])>=freq.get(arr[stack.peek()])) {
				stack.pop();
			}

			if(stack.isEmpty()){
				ngf[i] = -1;
			}

			else{
				ngf[i] = arr[stack.peek()];
			}

			stack.push(i);
		}

		for(int e:ngf){
			System.out.print(e+" ");
		}
	}

	public static void main(String[] args) {
		
		 int arr[]= {1, 1, 2, 3, 4, 2, 1};
		 next_greater_freq_ele(arr);	
	}
}