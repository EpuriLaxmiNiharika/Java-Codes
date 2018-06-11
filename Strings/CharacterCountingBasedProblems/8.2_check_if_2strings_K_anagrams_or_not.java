// https://www.geeksforgeeks.org/check-two-strings-k-anagrams-not/

/*

Two strings are called k-anagrams if following two conditions are true.

Both have same number of characters.
Two strings can become anagram by changing at most k characters in a string(only from one string).


METHOD: Instead of storing all the freq of characters in str1 and str2. Just store freq of characters of one(first/second) string.
While traversing the other(second/first) string. Count the diff in number of chars in second compared to first string 
*/

 class Main {

  	static boolean arekAnagrams(String str1, String str2, int k){

  		if(str1.length()!=str2.length()){
  			return false;
  		}

  		int[] count1 = new int[256];
  		

  		for(int i = 0; i<str1.length();i++){
  			Character character = str1.charAt(i);
  			int count_character = count1[str1.charAt(i)];
  			count1[str1.charAt(i)] = count_character+1;
  		}

  		int diff_chars = 0;
  		for(int i = 0; i<str2.length();i++){
  			Character character = str2.charAt(i);
        int count_character_str1 = count1[character];
        if(count_character_str1==0){
          diff_chars++;
        }
        else{
          count1[character] = count_character_str1-1;
        }
  		}

  		System.out.println(diff_chars);

  		return (diff_chars<=k);
  	}
 
    // Driver code
    public static void main(String args[])
    {
        String str1 = "grammar";
        String str2 = "anagram";
        int k = 3;
        if (arekAnagrams(str1, str2, k))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}