
//Generate all words separated by space. One by one reverse words and print them separated by space.

class ReverseWords{

	static void reverse(String s){

		String str[] = s.split(" ");

		for(int i = 0; i<str.length;i++){

			System.out.print(reverseString(str[i])+" ");
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