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


class Main{

	static String infix_to_postfix(String str){

		Stack stack = new Stack();

		String postfix = "";

		for(int i = 0; i< str.length() ; i++){

		
			String character = str.charAt(i)+"";

			if(character.equals("(")){
				stack.push("(");
			}

			else if(character.equals(")")){
				while (!stack.top.value.equals("(")) {

					postfix = postfix + stack.pop().value;
				}
				stack.pop();
			}

			else if(isOperator(character)){
				postfix = getPostfix( stack,  character,  postfix);
			}

			else{
				postfix = postfix + character;
			}
		}

		while(!stack.isEmpty()){
			postfix = postfix + stack.pop().value;
		}
		
		return postfix;
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

	static String getPostfix(Stack stack, String operator, String current_postfix){

		int priority = getpriority(operator);

		if(stack.isEmpty()){
			stack.push(operator);
			return current_postfix;
		}
	
		boolean popped_operators = false;
		while(stack.top!=null){

			if(isOperator(stack.top.value) && priority<=getpriority(stack.top.value)){
				current_postfix = current_postfix + stack.pop().value;
				popped_operators = true;
			}

			else{
				stack.push(operator);
				return current_postfix;
			}
		}

		if(popped_operators){
			stack.push(operator);
		}
	

		return current_postfix;
	}


	public static void main(String[] args) {

		 String exp = "a+b*(c^d-e)^(f+g*h)-i";
         System.out.println(infix_to_postfix(exp));
	}

}

