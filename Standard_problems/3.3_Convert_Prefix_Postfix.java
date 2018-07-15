import java.util.*;

class Prefix_PostFix{


	boolean isOperator(Character character){

		if(character=='+' || character=='-' || character == '*' || character == '/' || character=='^' || character=='(' || character==')'){
			return true;
		}
		return false;
	}

	

	void prefix_postfix(String s){

		Stack<String> stack = new Stack<String>();

		for(int i = s.length()-1; i>=0;i--){

			Character character = s.charAt(i);

			if(!isOperator(character)){

				stack.push(character+"");
			}
			else{
				String op1 = stack.pop();
				String op2 = stack.pop();

				stack.push(op1+op2+character);
			}
		}

		System.out.println(stack.peek());
	}

	
	public static void main(String[] args) {
		
		Prefix_PostFix pf = new Prefix_PostFix();
		pf.prefix_postfix("*-A/BC-/AKL");
	}
}