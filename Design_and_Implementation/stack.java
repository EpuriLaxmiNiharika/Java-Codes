import java.util.*;

class NGE{

	static Stack<Integer> stack = new Stack<Integer>();

	static void nge(int[] arr){

		System.out.println(arr[arr.length-1]+"---->"+"-1");

		stack.push(arr[arr.length-1]);

		for(int i = arr.length-2; i>=0; i--){

			int ele = arr[i];

			while (!stack.isEmpty() && stack.peek()<ele) {
				
				stack.pop();
			}

			if(stack.isEmpty()){

				System.out.println(ele+"---->"+"-1");
			}
			else{
					System.out.println(ele+"---->"+stack.peek());
			}

			stack.push(ele);
		}
	}

	public static void main(String[] args) {
		
		int[] nge = {13, 7, 6, 12};
		nge(nge);
	}
}
