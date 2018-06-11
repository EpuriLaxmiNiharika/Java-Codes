class Main{

	static void find_kth_char(String s, int k){

		String str = "";
		for(int i = 0; i<s.length();){

			Character character = s.charAt(i);
			String character_sub_str = "";
			String freq_character = "";
			while (character>='a' && character<='z' && i<s.length()) {
				character_sub_str = character_sub_str + character;
				i++;
				character = s.charAt(i);
				
			}

			if(i<s.length()){
				while(Character.isDigit(character) && i<s.length()){
					freq_character = freq_character + character;
					i++;
					if(i<s.length()){
						character = s.charAt(i);
					}
					else{
						break;
					}
				}
			}
			Integer freq = Integer.parseInt(freq_character);

			for(int i1 = 0; i1<freq;i1++){
				str = str + character_sub_str;
			}
		}
		if(k<str.length()){
			System.out.println(""+str.charAt(k-1));
		}
		else{
			System.out.println("K>SIZE OF STRING");
		}
	}

	public static void main(String[] args) {
		find_kth_char("ab4c12ed3",21);
	}
}