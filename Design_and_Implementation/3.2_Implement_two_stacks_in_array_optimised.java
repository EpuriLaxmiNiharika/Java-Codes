class TwoStacks{

	int[] arr; 
	int top1,top2;

	TwoStacks(int size){
		arr = new int[size];
		for(int i = 0; i<arr.length; i++){
			arr[i] = 0;
		}
		top1 = -1;
		top2 = arr.length;
	}
	
	void push1(int value){
	
		if((top1+1)<top2){ // there is space for element in first stack

			top1++;
			arr[top1] = value;
		}
		else{
			System.out.println("Sorry first stack is full!!");
		}
	}

	void push2(int value){
		
		if((top2-1)>top1){ // there is space for element in second stack
			top2--;
			arr[top2] = value;
		}
		else {
			System.out.println("Sorry second stack is full!!");
		}
	}

	int pop1(){
		
		if(top1==-1){
			System.out.println("Empty stack");
			return -1;
		}
		else{
			int value = arr[top1];
			top1--;
			return value;
		}
	}

	int pop2(){
		
		if(top2==arr.length){
			System.out.println("Empty stack");
			return -1;
		}
		else{
			int value = arr[top2];
			top2++;
			return value;
		}

	}

	void printArray(){
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");

	}
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11); 
        ts.push2(7);
        System.out.println("Popped element from" +
                           " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" +
                         " stack2 is " + ts.pop2());
	}
}