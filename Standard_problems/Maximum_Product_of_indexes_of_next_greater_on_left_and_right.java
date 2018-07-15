import java.util.*;

class MaxProduct{

	static void nextgreaterElementLeft(int[] arr,int[] left){

		left[0] = 0;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		for(int i = 1; i<arr.length;i++){

			int ele = arr[i];

			while (!stack.isEmpty() && arr[stack.peek()]<=ele) {
				
				stack.pop();
			}

			if(stack.isEmpty()){

				left[i] = 0;
			}
			else{

				left[i] = arr[stack.peek()];
			}

			stack.push(i);
		}
	}

	static void nextgreaterElementRight(int[] arr, int[] right){


		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr.length-1);

		right[arr.length-1] = 0;

		for(int i = arr.length-2; i>=0;i--){

			int ele =arr[i];

			while (!stack.isEmpty() && arr[stack.peek()]<=ele) {
				
				stack.pop();
			}

			if(stack.isEmpty()){

				right[i] = 0;
			}
			else{

				right[i] = arr[stack.peek()];
			}

			stack.push(i);
		}
	}

	static void maxProduct(int[] arr){

		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		nextgreaterElementLeft(arr,left);
		nextgreaterElementRight(arr,right);

		for(int e:left){
			System.out.print(e+" ");
		}

		System.out.println();


		for(int e:right){
			System.out.print(e+" ");
		}

		System.out.println();

		int max_product = Integer.MIN_VALUE;

		for(int i = 1; i<arr.length;i++){

			if(max_product<left[i-1] * right[i-1]){

				max_product = left[i-1] * right[i-1];
			}
		}

		System.out.println(max_product);
	}

	public static void main(String[] args) {
		int []arr = new int[]{ 6, 4, 5, 3, 4, 5,9,10 };

		maxProduct(arr);
	}
}