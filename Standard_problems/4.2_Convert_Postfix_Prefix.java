import java.util.*;

class PostFix_Prefix{


	boolean isOperator(Character character){

		if(character=='+' || character=='-' || character == '*' || character == '/' || character=='^' || character=='(' || character==')'){
			return true;
		}
		return false;
	}

	

	void postfix_prefix(String s){

		Stack<String> stack = new Stack<String>();

		for(int i = 0; i<=s.length()-1;i++){

			Character character = s.charAt(i);

			if(!isOperator(character)){

				stack.push(character+"");
			}
			else{
				String op1 = stack.pop();
				String op2 = stack.pop();

				stack.push(character+op2+op1);
			}
		}

		System.out.println(stack.peek());
	}

	
	public static void main(String[] args) {
		
		PostFix_Prefix pf = new PostFix_Prefix();
		pf.postfix_prefix("AB+CD-*");
	}
}