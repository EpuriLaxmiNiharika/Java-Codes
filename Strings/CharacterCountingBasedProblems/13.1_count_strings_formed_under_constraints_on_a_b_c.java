class Main{


	static void countStrings(int n){

		// only a

		int all_a = 1;

		// 1 b 2 c

		int one_b_two_c = n * (n-1)*(n-2)/2 *1;

		// 1b 1c

		int one_b_one_c = n * (n-1) * 1;

		//2c

		int two_c = n*(n-1)/2;

		// 1b

		int one_b = n;

		// 1c

		int one_c = n;

		int total_str = all_a+one_b + one_c + two_c + one_b_one_c + one_b_two_c;

		System.out.println(total_str);

	}

	 public static void main(String[] args) {
		
		countStrings(3);
	}
}