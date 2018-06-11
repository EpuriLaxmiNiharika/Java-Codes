class Main{


	static void printReverseString(String s){

		if(s.length()==1){
			System.out.print(s);
			return ;
		}

		printReverseString(s.substring(1,s.length()));
		
		System.out.print(s.charAt(0));

	}

	public static void main(String[] args) {
		
		printReverseString("niha");
	}

}