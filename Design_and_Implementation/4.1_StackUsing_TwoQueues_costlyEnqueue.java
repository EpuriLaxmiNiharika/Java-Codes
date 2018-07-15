import java.util.LinkedList;
import java.util.Queue;



class Stack{
	Queue<Integer> queue1;
	Queue<Integer> queue2;

	Stack(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int ele){
		if((queue2.peek() == null) && (queue1.peek() == null)){
			queue2.add(ele);
		}

		else{
			if(queue1.peek() == null){
				queue1.add(ele);
				while(queue2.peek()!= null){
					queue1.add(queue2.remove());
				}
			}
			else{
				queue2.add(ele);
				while(queue1.peek()!= null) {
					queue2.add(queue1.remove());
				}
			}
		}
	}


	public int pop(){

		if((queue2.peek() == null) && (queue1.peek() == null)) {
			return -1;

		}
		if(queue2.peek() == null)
			return queue1.remove();
		
		return queue2.remove();

	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
   		s.push(2);
    	s.push(3);
    	System.out.println("dequeued: "+s.pop());
    	System.out.println("dequeued: "+s.pop());
    	s.push(4);
    	System.out.println("dequeued: "+s.pop());
	}

}