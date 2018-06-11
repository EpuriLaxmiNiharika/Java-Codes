import java.util.*;
import java.util.Map.*;

class Main{

	static String sort_String(String s){

		TreeSet<Character> set = new TreeSet<Character>();

		for(int i = 0; i<s.length();i++){
			set.add(s.charAt(i));
		}	

		String s1 = "";
		for(Character c: set){
			s1 = s1+c; 
		}
	//	System.out.println(s1);
		return s1;
	}


	static void group_words(String[] arr){

		HashMap<String,ArrayList<Integer>> hm = new HashMap<String,ArrayList<Integer>>();

		for(int i = 0; i<arr.length;i++){

			String word = arr[i];
			String word_sorted  = sort_String(word);

		//	System.out.println(word_sorted+"----"+word);

			ArrayList<Integer> ar_lst = hm.get(word_sorted);


			if(ar_lst==null){
				ar_lst = new ArrayList<Integer>();
				ar_lst.add(i);
				hm.put(word_sorted,ar_lst);
			}
			else{
				ar_lst.add(i);
				hm.put(word_sorted,ar_lst);
			}
		}

		for(Entry<String,ArrayList<Integer>> e: hm.entrySet()){
			ArrayList<Integer> values = e.getValue();
			System.out.print("[ ");
			for(Integer str:values){
				System.out.print(arr[str]+" ");
			}
			System.out.print("]\n");
		}	
	}

	public static void main(String[] args) {
		String words[] = { "may", "student", "students", "dog",
                     "studentssess", "god", "cat", "act", "tab",
                     "bat", "flow", "wolf", "lambs", "amy", "yam",
                     "balms", "looped", "poodle"};
        int n = words.length;
        group_words(words);
	}

}