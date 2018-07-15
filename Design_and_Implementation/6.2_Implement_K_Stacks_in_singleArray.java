//https://www.youtube.com/watch?v=DxW7VAsdX0o

import java.util.*;

class KStacks{

	int[] topOfStack;
	int[] stackData;
	int[] nextIndex;
	int nextAvailable;
	int num_stacks;
	int capacity;

	KStacks(int num_stacks, int capacity){

		this.num_stacks = num_stacks;
		this.capacity = capacity;

		topOfStack = new int[num_stacks];
		
		Arrays.fill(topOfStack,-1);

		stackData = new int[capacity];
		
		nextIndex  = new int[capacity];
		
		for(int i = 0; i<capacity-1;i++){
			nextIndex[i] = i+1;
		}

		nextIndex[capacity-1] = -1;

		nextAvailable = 0;
	}


	void push(int value, int stack){

		if(nextAvailable<0 || stack<0 || stack>num_stacks){
			System.out.println("stack full or invalid");
			return;
		}

		int current_index = nextAvailable;
		nextAvailable =  nextIndex[current_index];
		stackData[current_index] = value;
		nextIndex[current_index] = topOfStack[stack];
		topOfStack[stack] = current_index;
	}

	int pop(int stack){
		if(topOfStack[stack]<0 || stack<0 || stack>num_stacks){
			System.out.println("stack is empty");
			return -1;
		}

		int current_index = topOfStack[stack];// pop this index value
		int value = stackData[current_index];
		topOfStack[stack] = nextIndex[current_index]; 
		nextIndex[current_index] = nextAvailable;
		nextAvailable = current_index;

		return value;
	}

	public static void main(String[] args) {
		int k = 3, n = 10;
		KStacks ks = new KStacks(k,n);

		ks.push(15, 2);
        ks.push(45, 2);
 
        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
 
        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}