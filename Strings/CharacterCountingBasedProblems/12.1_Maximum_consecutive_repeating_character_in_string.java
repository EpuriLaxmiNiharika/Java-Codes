import java.util.*;

class Main{

	static void find_max_repeating_char(String s){

		int[] count = new int[256];
		Arrays.fill(count,0);
		int max_count = 0;
		Character max_freq_char = s.charAt(0);
		int count_char =0;
		for(int i = 1; i<=s.length()-1;i++){
			
			if(s.charAt(i-1)==s.charAt(i)){
				count_char = count_char+1;
			}

			else{
				count_char++;
				if(max_count<count_char){
					max_freq_char = s.charAt(i-1);
					max_count = count_char;
					count_char =0;
				}
			}
		}
		
		System.out.println(max_freq_char +"---"+max_count);

	}

	public static void main(String[] args) {
		
		find_max_repeating_char("geeekk");
	}
}