class Stack{

	int[] arr;

	int top;

	Stack(int size){

		arr = new int[size];
		top = -1;
	}

	void push(int value){

		top++;
		arr[top] = value;
	}

	int pop(){
		if(top==-1){
			return -1;
		}

		int val = arr[top];
		top--;
		System.out.println(val);
		return val;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(6);
		stack.push(10);
		stack.push(20);
		stack.pop();
		stack.push(30);
		stack.push(40);
		stack.pop();
	}
}