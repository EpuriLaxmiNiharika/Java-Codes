//https://www.geeksforgeeks.org/prefix-infix-conversion/

/*

Algorithm for Prefix to Infix:

    Read the Prefix expression in reverse order (from right to left)
    If the symbol is an operand, then push it onto the Stack
    If the symbol is an operator, then pop two operands from the Stack
    Create a string by concatenating the two operands and the operator between them.
    string = (operand1 + operator + operand2)
    And push the resultant string back to Stack
    Repeat the above steps until end of Prefix expression.


*/


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

	static String convertPrefixtoInfix(String str){

		Stack stack = new Stack();

		StringWrapper wrapper = new StringWrapper();
		String Prefix = "";

		for(int i = str.length()-1; i>=0; i--){
			String character = str.charAt(i)+"";
			convertPreFix_to_infix_util(stack,character);
			//printStack(stack);

		}

	//	System.out.println(stack.top.value);
		return stack.top.value;
	}


	static void convertPreFix_to_infix_util(Stack stack, String character){

		if(isOperator(character)){

			if(!stack.isEmpty()){

				String operand1 = stack.pop().value;
				if(!stack.isEmpty()){
					String operand2 = stack.pop().value;
					stack.push("("+operand1 + character + operand2 + ")");
				}
			}
		}
		else{
			stack.push(character);
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

		 String exp = "*-A/BC-/AKL";
         System.out.println(convertPrefixtoInfix(exp));
	}

}

