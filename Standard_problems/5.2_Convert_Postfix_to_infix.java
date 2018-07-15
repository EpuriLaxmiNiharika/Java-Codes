import java.util.*;

class Postfix_Infix{


	boolean isOperator(Character character){

		if(character=='+' || character=='-' || character == '*' || character == '/' || character=='^' || character=='(' || character==')'){
			return true;
		}
		return false;
	}

	
	void postfix_infix(String s){

		Stack<String> stack = new Stack<String>();

		for(int i = 0; i<s.length();i++){

			Character character = s.charAt(i);

			if(!isOperator(character)){

				stack.push(character+"");
			}
			else{

				String op1 = stack.pop();
				String op2 = stack.pop();

				stack.push("("+op2+character+op1+")");
			}
		}

		System.out.println(stack.peek());
	}

	
	public static void main(String[] args) {
		
		Postfix_Infix pf = new Postfix_Infix();
		pf.postfix_infix("ab*c+");
	}
}