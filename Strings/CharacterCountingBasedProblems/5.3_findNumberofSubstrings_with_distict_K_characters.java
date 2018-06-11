
import java.util.*;

class Main{
	public static void findSubstringsWithKDistinctCharacters(String s, int k) {
	   	int[] count = new int[26];
		int result =0;
		for(int i = 0; i<s.length();i++){
			Arrays.fill(count,0);
			int distinct_chars = 0;
	   		for(int j = i; j<s.length();j++){
	   			if(count[s.charAt(j)-'a']==0){
	   				distinct_chars ++;
	   			}

	   			count[s.charAt(j)-'a']++;

	   			if(distinct_chars==k){
	   				result = result + 1;
	   			}

	   			else if(distinct_chars>k){
	   				break;
	   			}
	  		}
	   	}
	   	System.out.println(result);
	}
	
	public static void main(String[] args) {
		findSubstringsWithKDistinctCharacters("abcbaa",3);
	}
}