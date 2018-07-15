//We use a stack to push all words before space. As soon as we encounter a space, we empty the stack.

import java.util.*;

class ReverseWords{

	static void reverse(String s){

		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i<s.length();i++){

			char character = s.charAt(i);

			if(character==' '){

				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
			}
			else{
				stack.push(character);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

	static String reverseString(String s){

		StringBuilder builder = new StringBuilder();
		return builder.append(s).reverse().toString();
	}

	public static void main(String[] args) {
		
		String s = "Hello World";
		reverse(s);
	}
}