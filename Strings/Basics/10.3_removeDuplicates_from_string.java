
import java.util.*;
class Main{

	static String removeDuplicates(String s){

		String s1 ="";
		for(int i = 0; i<s.length();i++){
			Character character = s.charAt(i);
			if(s1.indexOf(character)>=0){

			}
			else{
				s1 = s1 + character;
			}
		}
		
		System.out.println(s1);
		return s1;	
	}


	public static void main(String[] args) {
		
		removeDuplicates("niharika");
	}
}