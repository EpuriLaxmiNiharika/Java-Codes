/*
	https://www.geeksforgeeks.org/expression-evaluation/


	1. While there are still tokens to be read in,
   1.1 Get the next token.
   1.2 If the token is:
       1.2.1 A number: push it onto the value stack.
       1.2.2 A variable: get its value, and push onto the value stack.
       1.2.3 A left parenthesis: push it onto the operator stack.
       1.2.4 A right parenthesis:
         1 While the thing on top of the operator stack is not a 
           left parenthesis,
             1 Pop the operator from the operator stack.
             2 Pop the value stack twice, getting two operands.
             3 Apply the operator to the operands, in the correct order.
             4 Push the result onto the value stack.
         2 Pop the left parenthesis from the operator stack, and discard it.
       1.2.5 An operator (call it thisOp):
         1 While the operator stack is not empty, and the top thing on the
           operator stack has the same or greater precedence as thisOp,
           1 Pop the operator from the operator stack.
           2 Pop the value stack twice, getting two operands.
           3 Apply the operator to the operands, in the correct order.
           4 Push the result onto the value stack.
         2 Push thisOp onto the operator stack.

	2. While the operator stack is not empty,
	    1 Pop the operator from the operator stack.
	    2 Pop the value stack twice, getting two operands.
	    3 Apply the operator to the operands, in the correct order.
	    4 Push the result onto the value stack.
	3. At this point the operator stack should be empty, and the value
	   stack should have only one value in it, which is the final result.

*/



import java.util.*;

class EvaluateString{

	static int evaluate(String s){

		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();

		char[] tokens = s.toCharArray();

		try{
			for(int i = 0; i<tokens.length;i++){

				if(tokens[i]==' '){
					continue;
				}

				if(tokens[i]>='0' && tokens[i]<'9'){

					StringBuffer buf = new StringBuffer();
					while (i<tokens.length && tokens[i]>='0' && tokens[i]<='9') {
					 	
					 	buf.append(tokens[i]);
					 	i++;
					}
					values.add(Integer.parseInt(buf.toString())); 
					//System.out.println("---"+values.peek());
				}

				else if(tokens[i]=='('){
					operators.push(tokens[i]);
				}

				else if(tokens[i]==')'){

					while(!operators.isEmpty() && operators.peek()!='('){

						Integer val2 = values.pop();
						Integer val1 = values.pop();
						Character op = operators.pop();
						values.push(applyOp(val1,op,val2));
					}
					operators.pop(); // POP '('
				}
				else if(tokens[i]=='+' || tokens[i]=='-' || tokens[i]=='*' || tokens[i]=='/'){

					while(!operators.isEmpty() && precedence(tokens[i])<=precedence(operators.peek())){

						Integer val2 = values.pop();
						Integer val1 = values.pop();
						Character op = operators.pop();	

						values.push(applyOp(val1,op,val2));
					}

					operators.push(tokens[i]);
				}
			}
			 while (!operators.empty()){
	            Integer val2 = values.pop();
				Integer val1 = values.pop();
				Character op = operators.pop();
				values.push(applyOp(val1,op,val2));
	        }

	        return values.pop();
	    }

	    catch(Exception e){

	    }

	    return 0;
	}

	static int precedence(char c){

		if(c=='+' || c=='-'){
			return 1;
		}

		else if(c=='*' || c=='/'){
			return 2;
		}

		else{

			return 0; // if char = '(' || ')'
		}
	}

	static int applyOp(int num1, char op, int num2) throws Exception{

		switch (op) {
			
			case '+':
				return num1 + num2;

			case '-':
				return num1 - num2;

			case '*':
				return num1*num2;

			case '/':
				if(num2==0){
					throw new Exception("Cannot divide by zero");
				}

				return num1/num2;			 
		}

		return 0;
	}

	public static void main(String[] args) {
		
		System.out.println(EvaluateString.evaluate("10 + 2 * 6"));
        System.out.println(EvaluateString.evaluate("100 * 2 + 12"));
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
	}
}