class Node{

	String value;
	Node next;

	Node(String value){
		this.value = value;
	}
}


class Stack{

	Node top;
	int size;
	
	Stack(){
		top = null;
		size = 0;
	}

	void push(String element){

		if(isEmpty()){
			top = new Node(element);
			size++;
			return;
		}

		size ++;
		Node new_node = new Node(element);
		new_node.next = top;
		top = new_node;
	}

	Node pop(){
		if(isEmpty()){
			System.out.println("Stack empty!!");
			return null;
		}

		Node temp = top;
		top = top.next;
		size--;
		return temp;
	}

	boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
}

class StringWrapper{

	String postfix;

	StringWrapper(){
		postfix = "";
	}
}

class Main{

	static String infix_to_postfix(String str){

		Stack stack = new Stack();

		StringWrapper wrapper = new StringWrapper();
		String postfix = "";

		for(int i = 0; i< str.length() ; i++){

			String character = str.charAt(i)+"";
			convertPostFix(stack,character,wrapper);
			//printStack(stack);

		}

		while (!stack.isEmpty()) {
			wrapper.postfix = wrapper.postfix+stack.pop().value;
		}

		postfix = wrapper.postfix;
		return postfix;
	}

	static void convertPostFix(Stack stack, String character,StringWrapper wrapper){
		String postfix = wrapper.postfix;

		//System.out.println("character: "+character);

		if(character.equals("(")){
	//		System.out.println("pushed "+character);
			stack.push("(");
		}

		else if(character.equals(")")){

			while (!stack.top.value.equals("(")) {	
				postfix = postfix+stack.pop().value;
				wrapper.postfix = postfix;
			}

			stack.pop();
		}

		else{

			boolean is_operator = isOperator(character);

			if(is_operator){

				int priority = getpriority(character);

				int stack_top_priority = -1;
				if(!stack.isEmpty()){ // check the priority of already existing top and update stack if needed

					boolean ispopped = false;
					while (!stack.isEmpty()) {
						if(getpriority(stack.top.value) >= priority){
							ispopped = true;
							String popped = stack.pop().value;
							postfix= postfix+popped;
							wrapper.postfix = postfix;
						}
						else{
							break;
						}
					}
					stack.push(character);
				}
				
				else{
					stack.push(character);
			//		System.out.println("pushed "+character);
				}
			}
			else{
				postfix = postfix + character;
		//		System.out.println("postfix "+postfix);
				wrapper.postfix = postfix;
			}
		}
	}

	static void printStack(Stack s){
		Node temp = s.top;
		while (temp!=null) {
			System.out.print(" "+temp.value);
			temp = temp.next;
		}
		System.out.print(" \n");
	}

	static boolean isOperator(String character){

		if(character.equals("*") || character.equals("+") || character.equals("-") || character.equals("/") || character.equals("^")){
			return true;
		}

		return false;
	}


	 static int getpriority(String ch){
        switch (ch)
        {
        case "+":
        case "-":
            return 1;
      
        case "*":
        case "/":
            return 2;
      
        case "^":
            return 3;
        }
        return -1;
    }

	public static void main(String[] args) {

		 String exp = "a+b*(c^d-e)^(f+g*h)-i";
         System.out.println(infix_to_postfix(exp));
	}

}

