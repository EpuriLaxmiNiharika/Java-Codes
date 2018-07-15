import java.util.*;

class Prefix_Infix{


	boolean isOperator(Character character){

		if(character=='+' || character=='-' || character == '*' || character == '/' || character=='^' || character=='(' || character==')'){
			return true;
		}
		return false;
	}

	String reverse(String s){

		String output = "";

		for(int i  = s.length()-1;i>=0; i--){
			Character character = s.charAt(i);

			if(character==')'){
				output = output + '(';
			}
			else if(character=='('){
				output = output + ')';
			}
			else{
				output = output + character;
			}
		}
		return output;
	}


	void prefix_infix(String s){

		Stack<String> stack = new Stack<String>();

		for(int i = s.length()-1; i>=0;i--){

			Character character = s.charAt(i);

			if(!isOperator(character)){

				stack.push(character+"");
			}
			else{

				String op1 = stack.pop();
				String op2 = stack.pop();

				stack.push("("+op1+character+op2+")");
			}
		}

		System.out.println(stack.peek());
	}

	
	public static void main(String[] args) {
		
		Prefix_Infix pf = new Prefix_Infix();
		pf.prefix_infix("*-A/BC-/AKL");
	}
}