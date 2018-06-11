import java.util.*;
class Main{

	static boolean checkAllChars(int[] pattern_chars, int[] str_chars){

		for(int i = 0; i<pattern_chars.length;i++){
			if(pattern_chars[i]<=str_chars[i]){
				return true;
			}
		}
		return false;
	}

	static String smallestWindow(String str, String pattern){

		HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();

		for(int i = 0; i<str.length();i++){
			hashmap.put(str.charAt(i),0);
		}

		for(int i = 0; i<pattern.length();i++){

			Character character = pattern.charAt(i);
			if(hashmap.containsKey(character)){
				int count = hashmap.get(character);
				hashmap.put(character,count+1);
			}
			else{
				return "";
			}
		}

		int num_targets = pattern.length();
		int min_window_size = Integer.MAX_VALUE;
		int start=0,end = 0;
		int min_start = Integer.MAX_VALUE, min_end = Integer.MAX_VALUE;
		
		while (end<str.length()) {
			
			Character character = str.charAt(end);
			
			if(hashmap.get(character)>0){
				num_targets --;
			}

			hashmap.put(character,hashmap.get(character)-1);

			while (num_targets==0) {
				
				// update the window size

				if(min_window_size>(end-start+1)){
					min_window_size = end-start+1;
					min_start = start;
					min_end =end;
				}

				// move the window start if required

				Character head = str.charAt(start);
				
				if(hashmap.get(head)==0){
					num_targets++;
				}
				
				hashmap.put(head,hashmap.get(head)+1);
				start++;
			}
			end++;	
		}

		System.out.println(str.substring(min_start,min_end+1));
		return str.substring(min_start,min_end+1);
	}



	public static void main(String[] args) {
		
		String str = "iiiaarri";
        String pat = "ri";

		smallestWindow(str,pat);
	}
}