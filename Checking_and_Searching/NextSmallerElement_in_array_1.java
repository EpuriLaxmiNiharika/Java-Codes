import java.util.*;

class Main{

	static void nextSmallerElement(int[] arr){

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(arr[0]);

		for(int i = 1;i<arr.length;i++){

			int next = arr[i];

			if(!stack.isEmpty()){
				int top = stack.pop();
				
				while (next<top) {
					System.out.println(top+"--->"+next);
					if(stack.isEmpty()){
						break;
					}
					else{
						top = stack.pop();
					}
				}

				if(top<next){
					stack.push(top);
				}
			}

			stack.push(next);
		}

		while(!stack.isEmpty()){
			int top = stack.pop();
			System.out.println(top+"---NO NEXT SMALLER ELE");
		}
	}

	public static void main(String[] args) {
		 int arr[] = {1,2,3,4,5,6,7};
		 nextSmallerElement(arr);

	}
}