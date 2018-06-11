import java.util.*;

class Main{

	static int countWords(String str){

		int word_count = 0;

		str = str.replaceAll("\n", "   ");
		str = str.replaceAll("\t", "   ");
		str = str.trim().replaceAll(" +", " "); 
		for(int i = 0; i<str.length();i++){
			 if (str.charAt(i) == ' '){
			 	word_count = word_count+1;
			 }  
		}

		System.out.println(word_count+1);
		return word_count+1;
	}

	public static void main(String[] args) {
		
		countWords("One two       three\n four\tfive  ");
	}
}