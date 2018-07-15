import java.util.*;


class EvaluateExpression{

	static int evaluatePostfix(String s){

		Stack<Integer> values = new Stack<Integer>();
	
		try{
			for(int i=0; i<s.length();i++){

				if(s.charAt(i)==' '){
					continue;
				}

				if(s.charAt(i)>='0' && s.charAt(i)<='9'){

					StringBuffer buf = new StringBuffer();
					while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
						buf.append(s.charAt(i));
						i++;
					}

					values.push(Integer.parseInt(buf.toString()));

				}

				else if(s.charAt(i)=='*' || s.charAt(i)=='/' || s.charAt(i)=='+' || s.charAt(i)=='-'){

					if(values.size()>1){

						Integer val1 = values.pop();
						Integer val2 = values.pop();

						values.push(applyOp(val2,s.charAt(i),val1));
					}
				}
			}
			return values.pop();
		}

		catch(Exception e){


		}

		return 0;
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
		String exp="100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
	}
}