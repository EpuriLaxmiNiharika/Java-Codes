import java.util.*;

class Main{

	static void findNextGreaterElement(int[] arr){

		Stack<Integer> stack =new Stack<Integer>();

		stack.push(arr[0]);

		for (int i = 1; i<arr.length; i++) {
			int next = arr[i];
			int top = stack.pop();

			while(top<next){
				System.out.println(top+"---"+next);	
				if(stack.isEmpty()){
					break;
				}			
				top = stack.pop();
			}

			if(top>next){
				stack.push(top);
			}

			stack.push(next);	
		}

		while(!stack.isEmpty()){
			int top = stack.pop();
			System.out.println(top+"---NOT FOUND");		
		}	
	}

	public static void main(String[] args) {
		
		int[] arr = new int[]{8,7,6,3,2,1,5,4,11,6,10};
		findNextGreaterElement(arr);
	}
}