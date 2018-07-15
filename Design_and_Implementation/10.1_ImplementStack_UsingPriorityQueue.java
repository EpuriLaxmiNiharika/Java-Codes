import java.util.Comparator;
import java.util.PriorityQueue;

class StackElement{

	int key;
	int value;

	StackElement(int key, int value){
		this.key = key;
		this.value = value;
	}

}

class Stack{

	int count;
	PriorityQueue<StackElement> pqueue;

	Stack(int size){
		count = 0;
		pqueue = new PriorityQueue<StackElement>(size, new Comparator<StackElement>(){

			public int compare(StackElement s1, StackElement s2){ // based on keys we are building priority queue in ascending order
				if(s1.key<s2.key){ // increasing order of priority. TOP ELEMENT has MAX Priority
					return 1;
				}
				else if(s1.key>s2.key){
					return -1;
				}
				return 0;
			}

		});
	}


	public void push(int element){
		count++;
		StackElement s1 = new StackElement(count,element);
		pqueue.add(s1);

	}

	public int pop(){
		if(pqueue.isEmpty()){
			System.out.println("No elements in Priorityqueue");
			return -1;
		}
		else
			{
				count--;
				int val = pqueue.poll().value;
				System.out.println("Popped element: "+val);
				return val;
			}

	}
	public static void main(String[] args) {
		Stack s1 = new Stack(10);
		s1.push(1);
		s1.push(3);
		s1.push(2);
		s1.push(10);
		s1.pop();
	}
}