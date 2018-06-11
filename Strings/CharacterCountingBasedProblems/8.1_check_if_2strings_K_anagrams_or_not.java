// https://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/

/*

Two strings are called k-anagrams if following two conditions are true.

Both have same number of characters.
Two strings can become anagram by changing at most k characters in a string(only from one string).

*/

 class Main {

  	static boolean arekAnagrams(String str1, String str2, int k){

  		if(str1.length()!=str2.length()){
  			return false;
  		}

  		int[] count1 = new int[256];
  		int[] count2 = new int[256];

  		for(int i = 0; i<str1.length();i++){
  			Character character = str1.charAt(i);
  			int count_character = count1[str1.charAt(i)];
  			count1[str1.charAt(i)] = count_character+1;
  		}


  		for(int i = 0; i<str2.length();i++){
  			Character character = str2.charAt(i);
  			int count_character = count2[str2.charAt(i)];
  			count2[str2.charAt(i)] = count_character+1;
  		}

  		int diff_chars = 0;
  		for(int i = 0; i<256;i++){
  			// counting diff number of chars in second string while comparing it with first
  			if(count2[i]>count1[i]){
  				diff_chars = diff_chars + count2[i] - count1[i];
  			}
  		}

  		System.out.println(diff_chars);

  		return (diff_chars<=k);
  	}
 
    // Driver code
    public static void main(String args[])
    {
        String str1 = "abg";
        String str2 = "abgh";
        int k = 2;
        if (arekAnagrams(str1, str2, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}