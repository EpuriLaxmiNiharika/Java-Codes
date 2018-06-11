import java.util.*;

class Main{

	static void count_substrings(String s){
			
		int count_substr = 0;
		int[] count = new int[256];

		Arrays.fill(count,0);
		
		for(int i = 0; i<s.length();i++){
			count[s.charAt(i)] = count[s.charAt(i)]+1;
		}

		for(int i = 0; i<count.length;i++){

			count_substr = count_substr + (count[i] * (count[i] + 1))/2;
		}

		System.out.println(count_substr);
	}

	public static void main(String[] args) {
		count_substrings("abcab");
	}
}