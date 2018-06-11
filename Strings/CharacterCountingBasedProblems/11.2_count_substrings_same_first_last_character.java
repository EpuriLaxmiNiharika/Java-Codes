class Main{

	static void count_substrings(String s){
		int count = 0;
		for(int i = 0; i<s.length();i++){
			for(int j = i; j<s.length();j++){
				String sub_str = s.substring(i,j+1);
				if(sub_str.charAt(0)==sub_str.charAt(sub_str.length()-1)){
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		count_substrings("abcab");
	}
}