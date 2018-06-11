import java.util.*;
import java.util.Map.*;

class Main{


	static void count_Anagrams_Substrings(String s){

		HashMap<String,Integer> hm = new HashMap<String,Integer>();

		for(int i = 0; i<s.length();i++){
			for(int j = i; j<s.length();j++){
				String sub_str = s.substring(i,j+1);
				System.out.println(sub_str);
				char char_arr[] = sub_str.toCharArray();
				Arrays.sort(char_arr);
				sub_str = "";
				
				for(Character c:char_arr){
					sub_str = sub_str+c;
				}
				
				System.out.print("\n");
				if(hm.containsKey(sub_str)){
					int value = hm.get(sub_str);
					hm.put(sub_str,value+1);
				}
				
				else{
					hm.put(sub_str,1);
				}
			}
		}

		int count = 0;
		for(Entry<String,Integer> entry: hm.entrySet()){

			
			count = count + (entry.getValue()) * (entry.getValue() -1)/2;
			//count = count + entry.getValue();
		//	System.out.println(entry.getKey() + "---"+entry.getValue());

		}

		System.out.println(count);
	}

	public static void main(String[] args) {
		count_Anagrams_Substrings("kkkk");
	}
}