import java.util.Stack;

class Queue {
	
	Stack<Integer> stack = new Stack<Integer>();
	public void enqueue(int value){
		stack.push(value);
	}

	public int dequeue(){
		
		int size = stack.size();

		if(size==1){
			int popped = stack.pop();
			System.out.print(" "+popped);
			return popped;
		}

		int res = stack.pop();

		int popped = dequeue();

		stack.push(res);

		return popped;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(40);
		queue.enqueue(50);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(60);

	}
}