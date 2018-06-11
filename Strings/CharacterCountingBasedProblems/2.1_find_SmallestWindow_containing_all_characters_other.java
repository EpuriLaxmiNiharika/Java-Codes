/*

1- Generate all substrings of string1 (“this is a test string”)
2- For each substring, check whether the substring contains all characters of string2 (“tist”)
3- Finally, print the smallest substring containing all characters of string2.

*/


class Main{

	static boolean checkAllChars(int[] pattern_chars, int[] str_chars){

		for(int i = 0; i<pattern_chars.length;i++){
			if(pattern_chars[i]<=str_chars[i]){
				return true;
			}
		}
		return false;
	}

	static int smallestWindow(String str, String pattern){

		int small_window = Integer.MAX_VALUE;
		int[] str_chars = new int[256];
		int[] pattern_chars = new int[256];
		int start = 0;
		int min_start = Integer.MAX_VALUE;
		int min_end = Integer.MAX_VALUE;
		
		for(int i = 0; i<pattern.length();i++){
			pattern_chars[pattern.charAt(i) ]++;
		}

		for(int i = 0; i<str.length();i++){

			start = i;
			int iter = start;
			int count_matching = 0;
		
			for(int i1 = 0; i1<str.length();i1++){
				str_chars[str.charAt(i1)]=0;
			}

			while (iter<str.length()) {

				Character character = str.charAt(iter);
				int count_char_pattern = pattern_chars[character];
				int count_char_string = str_chars[character];


				if(count_char_string<count_char_pattern){
				//	System.out.println("not yet: "+start+ " --- "+iter);
				//	System.out.println("incrementing: "+character + " to: "+ (str_chars[character-'a']+1));
					str_chars[character]  = str_chars[character] +1;
				 	count_matching++;
				}

				if(count_matching==pattern.length()){
//					System.out.println(start+ " --- "+iter);
					int length = (iter - start);
					if(length<small_window){
						small_window = length;
						min_start = start;
						min_end = iter;
					}
					str_chars = new int[256];
					break;
				}
				iter ++;
			}
		}
		if(min_start!=Integer.MAX_VALUE){
			System.out.println(str.substring(min_start,min_end+1));
			//	System.out.println(min_start);
			//	System.out.println(min_end);
		}
		else{
			System.out.println("NO substring FOUND");
		}
	
		return small_window;
	}



	public static void main(String[] args) {
		
		String str = "this is a test string";
        String pat = "tist";

		smallestWindow(str,pat);
	}
}