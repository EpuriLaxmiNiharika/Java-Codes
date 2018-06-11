
import java.util.*;

class Main{


	public static void findSubstringsWithKDistinctCharacters(String s, int k) {
	    char[] letters = s.toCharArray();
	    int count =0;
	    for (int i = 0; i <letters.length; i++) {
	        Set<Character> uniques = new LinkedHashSet<Character>();
	   //     LinkedList<Character> chars = new LinkedList<Character>();
	        for (int j = i; j < letters.length; j++) {
	            uniques.add(letters[j]);
	       //     chars.add(letters[j]);
	            if (uniques.size() == k) { // computing size takes
	           	//	System.out.println("substring : " + uniques);
	            	count++;
	        	}
	        	else if(uniques.size()>k){
	        		break;
	        	}
	        }
	    }
	    System.out.println(count);
	}


	public static void main(String[] args) {
		findSubstringsWithKDistinctCharacters("abcbaa",3);
	}
}