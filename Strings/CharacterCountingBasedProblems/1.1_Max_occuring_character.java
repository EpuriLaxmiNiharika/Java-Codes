class Main{


	static void maxOccuringCharacter(String s){

		int[] char_count = new int[256];

		int max = 0;
		Character max_char = s.charAt(0);
		char_count[max_char]++;
		max = 1;
		for(int  i = 1;i<s.length();i++){
			int count = char_count[s.charAt(i)];
			count++;
			char_count[s.charAt(i)]++;
			if(count>max){
				max_char = s.charAt(i);
				max = count;
			}
		}

		System.out.print(max_char +"-- "+max);
	}

	public static void main(String[] args) {
		maxOccuringCharacter("niharika");
	}
}