import java.util.*;

class SortQueue{

	static void sort(Queue<Integer> queue){

		Stack<Integer> stack = new Stack<Integer>();

		int expected = 1; // expected element is eithe present at the front of queue or top of stack

		int len_queue = queue.size();

		int popped = 0;

		while (!queue.isEmpty()) {
		
			popped = queue.remove();

			if(popped==expected){
				
				expected++;
			}
			
			else{

				if(stack.isEmpty()){
					stack.push(popped);
				}

				else if(!stack.isEmpty() && stack.peek()<popped){

					System.out.println("no");
					return;
				}

				else{
					stack.push(popped);
				}
			}

			while(!stack.isEmpty() && stack.peek()==expected){
				stack.pop();
				expected++;
			}
		}

		if(expected==len_queue+1){
			System.out.println("yes");
		}
	}

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(5);queue.add(1);queue.add(2);queue.add(6);queue.add(3);queue.add(4);
		sort(queue);
	}
}
