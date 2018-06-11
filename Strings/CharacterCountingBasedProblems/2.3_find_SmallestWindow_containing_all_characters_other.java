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

		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

		for(int i = 0; i<str.length();i++){
			hm.put(str.charAt(i),0);
		}

		for(int i = 0; i<pattern.length();i++){
			if(hm.containsKey(pattern.charAt(i))){
				hm.put(pattern.charAt(i),hm.get(pattern.charAt(i))+1);
			}
			else{
				return "";
			}
		}

		int start = 0, end = 0, min_window_size = Integer.MAX_VALUE;
		int TargetCount = pattern.length();
		int min_start = 0;
		int min_end = 0;

		while (end<str.length()) {
			
			Character character = str.charAt(end);

			if(hm.get(character)>0){ // required character
				TargetCount --;	
			}

			hm.put(character,hm.get(character)-1);

	//		System.out.println(character+" :---: "+hm.get(character));

			while(TargetCount==0){ // window contains all the elements in pattern
				if(min_window_size>end-start+1){
					min_window_size = end-start +1;
					min_end = end;
					min_start = start;
				}

				Character head = str.charAt(start);

				if(hm.get(head)==0){ // moving head
				//	System.out.println(head+":head "+start);
					TargetCount++;
				}

				hm.put(head,hm.get(head)+1);
				start++;
			}

			if(start>0);

			end = end + 1;
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