class TwoStacks{

	int[] arr; 
	int top1,top2;
	int size;


	TwoStacks(int size){
		arr = new int[size];
		this.size = size;
		top1 = -1;
		top2 = size/2;
	}
	

	void push1(int value){ // push into first array.

		int len_array = arr.length;

		int half_len = len_array/2;

		if(top1==half_len){
			System.out.println("Stack is full");
			return;
		}

		else if(top1<half_len){
			top1++;
			arr[top1] = value;
		}
		else{
			return ;
		}
	}


	void push2(int value){
		
		int len_array = arr.length;

		if(top2==(len_array-1)){
			System.out.println("Stack is full");
			return;
		}

		else if(top2<(len_array-1)){
			top2++;
			arr[top2] = value;
		}
		else{
			return ;
		}
	}


	int pop1(){

		if(top1>0){

			int value = arr[top1];
			top1--;
			return value;
		}
		else{
			return -1;
		}
	}


	int pop2(){
		if(top2>0){

			int value = arr[top2];
			top2--;
			return value;
		}

		else{
			return -1;
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