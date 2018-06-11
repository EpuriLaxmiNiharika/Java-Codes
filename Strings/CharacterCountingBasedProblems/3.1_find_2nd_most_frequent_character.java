import java.util.*;

class Main{

	static char find_second_most_frequent_char(String s){


		int[] arr = new int[256];
		for(int i = 0; i<s.length();i++){
			arr[s.charAt(i)] = arr[s.charAt(i)] +1;
		}

		int second_freq = 0;
		int first_freq = 0;
		
		for(int i = 1;i<arr.length;i++){

			if(arr[i]>arr[first_freq]){
				int temp = first_freq;
				first_freq = i;
				second_freq = second_freq;
			}

			else if(arr[i]>arr[second_freq] && arr[i]<arr[first_freq]){
				second_freq = i;
			}
		}

		return (char)second_freq;

	}

	public static void main(String[] args) {
		
		System.out.println(find_second_most_frequent_char("niharikaa"));
	}
}