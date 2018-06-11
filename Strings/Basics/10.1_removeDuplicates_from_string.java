
// HashSet doesnot maintain elements in insertion order
		// LinkedHashset maintains elements in insertion order
		// TreeHashset maintains elements based on comparator we provide. 
			//If no comparator, then by default it's ascending order

import java.util.*;
class Main{

	static String removeDuplicates(String s){

		String s1 = "";
		Set<String> hash_set = new LinkedHashSet<String>();

		for(int i = 0; i<s.length();i++){
			hash_set.add(s.charAt(i)+"");
		}
		
		for(String character: hash_set){
			s1 = s1 + character;
		}

		System.out.println(s1);
		return s1;	
	}


	public static void main(String[] args) {
		
		removeDuplicates("niharika");
	}
}