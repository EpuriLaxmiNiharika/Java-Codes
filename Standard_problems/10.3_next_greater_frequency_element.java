import java.util.*;

class NextGreater_Frequency_Ele{

	static void ngf(int[] arr){

		HashMap<Integer,Integer> frequency = new HashMap<Integer,Integer>();

		for(int i = 0; i<arr.length;i++){

			Integer freq = frequency.get(arr[i]);

			if(freq==null){
				frequency.put(arr[i],1);
			}
			else{
				frequency.put(arr[i],freq+1);
			}
		}

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(0);

		for (int i = 1; i<=arr.length-1; i++) {
			

			while (!stack.isEmpty()&&frequency.get(arr[stack.peek()])<frequency.get(arr[i])) {
				System.out.println(arr[stack.peek()]+"--->"+arr[i]);	
				stack.pop();
			}

			stack.push(i);
		}

		while(!stack.isEmpty()){
			System.out.println(arr[stack.pop()]+"--->"+"-1");
		}
	}

	public static void main(String[] args) {
		
		int arr[] = {1, 1, 2, 3, 4, 2, 1};
		ngf(arr);
	}
}