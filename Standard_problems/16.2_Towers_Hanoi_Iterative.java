//    For n disks, total 2^n – 1 moves are required.

/*
	
	1. Calculate the total number of moves required i.e. "pow(2, n)- 1" here n is number of disks.
	2. If number of disks (i.e. n) is even then interchange destination 
	   pole and auxiliary pole.
	3. for i = 1 to total number of moves:
	     if i%3 == 1:
	    legal movement of top disk between source pole and 
	        destination pole
	     if i%3 == 2:
	    legal movement top disk between source pole and 
	        auxiliary pole    
	     if i%3 == 0:
	        legal movement top disk between auxiliary pole 
	        and destination pole 

*/

class TowersOfHanoi{

	class Stack{

		int capacity;
		int[] arr;
		int top;

		Stack(int capacity){

			this.capacity = capacity;
			arr = new int[capacity];
			top = -1;
		}
	}

	Stack createStack(int capacity){

		return new Stack(capacity);
	}

	void push(Stack stack, int item){

		if(isFull(stack)){
			return;
		}

		stack.top++;
		stack.arr[stack.top] = item;
	}

	int pop(Stack stack){

		if(stack.top==-1){
			return Integer.MIN_VALUE;
		}

		int item = stack.arr[stack.top];
		stack.top--;
		return item;
	}

	boolean isFull(Stack stack){

		if(stack.top==stack.capacity-1){

			return true;
		}

		return false;

	}

	void towers_hanoi(char from , char to, char aux, int n, Stack src_stack, Stack dest_stack, Stack aux_stack){
		
		for(int i = n;i>=1;i--){

			push(src_stack,i);
		}

		// System.out.println(from+"---"+to+"---"+aux);

		for(int i = 1; i<Math.pow(2,n); i++){

			if(i%3==1){
				moveDiskBetween(src_stack,dest_stack,from,to);
			}

			else if(i%3==2){
				moveDiskBetween(src_stack,aux_stack,from,aux);
			}

			else{
				moveDiskBetween(aux_stack,dest_stack,aux,to);
			}
		}
	}

	void moveDiskBetween(Stack src_stack, Stack dest_stack, char src, char dest){

		int src_top = pop(src_stack);

		int dest_top = pop(dest_stack);

		// System.out.println(src+"!!!!"+dest);

		if(src_top==Integer.MIN_VALUE){

			push(src_stack,dest_top);
			moveDisk(dest, src, dest_top);
		}

		else if(dest_top==Integer.MIN_VALUE){

			push(dest_stack,src_top);
			moveDisk(src, dest, src_top);
		}

		// place small value on top of big value

		else if(src_top>dest_top){

			push(src_stack,src_top);
			push(src_stack,dest_top);

			moveDisk(dest, src, dest_top);
		}

		else{//src_top < dest_top => move value from src to dest

			push(dest_stack,dest_top);
			push(dest_stack,src_top);
			moveDisk(src, dest, src_top);
		}
	}

	void moveDisk(char src, char dest, int value){

		System.out.println("moving value "+value+" from  src "+src +" to dest "+dest);
	}

	public static void main(String[] args) {
		

		int capacity = 3;

		TowersOfHanoi hanoi = new TowersOfHanoi();

		Stack src = hanoi.createStack(capacity);

		Stack aux = hanoi.createStack(capacity);

		Stack dest = hanoi.createStack(capacity);


		hanoi.towers_hanoi('A','C','B',capacity,src,dest,aux);
	}
}


