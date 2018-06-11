class Main{

	static void count_substrings(String s){
		int count = 0;
		for(int i = 0; i<s.length();i++){
			for(int j = i; j<s.length();j++){

				if(s.charAt(i)==s.charAt(j)){
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