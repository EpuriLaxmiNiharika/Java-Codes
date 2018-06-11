/*

1) Initialize 'count' = 0 (Count of non-space character seen so far)
2) Iterate through all characters of given string, do following
     a) If current character is non-space, then put this character
        at index 'count' and increment 'count'
3) Finally, put '\0' at index 'count'

*/

import java.util.*;
class Main{

	static String removeSpaces(String s){

		int count_non_space =0;

		for(int i = 0;i<s.length();i++){
			Character character = s.charAt(i);
			if(!character.equals(' ')){
				s = s.substring(0,count_non_space)+character+s.substring(count_non_space+1);
				count_non_space++; 
			}
		}
		 s = s.substring(0,count_non_space);
		System.out.println(s);
		return s;
	}


	public static void main(String[] args) {
		
		removeSpaces("The quick brown fox jumps over the lazy DOg...");
	}
}