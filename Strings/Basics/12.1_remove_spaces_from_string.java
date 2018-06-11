import java.util.*;
class Main{

	static String removeSpaces(String s){

		String s1 = s.replace(" ","");
		//String s1 = s.replaceAll("\\s","");
		//String s1 = s.replaceAll("\\s+","");
		System.out.print(s1);
		return s1;
	}


	public static void main(String[] args) {
		
		removeSpaces("The quick brown fox jumps over the lazy DOg...");
	}
}