// Maintain characters in Linked Hashset. Then while traversing if any duplicates are found then remove it.
import java.util.*;

class Main{

	static void find_Kth_non_repeatingChar(String s, int k){

		Set<Character> set = new LinkedHashSet<Character>();

		for(int i = 0; i<s.length();i++){
			Character character = s.charAt(i);
			if(set.contains(character)){
				set.remove(character);
			}
			else{
				set.add(character);
			}
		}

		if(set.size()<k){
			return;
		}

/*		Iterator<Character> iter = set.iterator();
		int count = 0;


		while (count<(k-1)) {
			iter.next();
			count++;
		}

		System.out.println(iter.next());
*/

		int count = 0;

		for(Character character:set){
			count++;
			
			if(count==k){
				System.out.println(character);
				break;
			}
		}

	}

	public static void main(String[] args) {
		find_Kth_non_repeatingChar("geeksforgeeks",3);
	}
}

