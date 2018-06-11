class Main{

	static void countChars(String s){
		int res = 0;
		for(int i = 0; i<s.length();i++){
			if(i==(s.charAt(i)-'a') || i == (s.charAt(i)-'A')){
				res = res +1;
			}
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		countChars("abceda");
	}
}