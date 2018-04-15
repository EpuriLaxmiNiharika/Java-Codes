class FindMaxSum{
	static void max_sum(int[] arr){
		int arr_len = arr.length;
		int max_sum, current_sum = 0;
		int arr_sum =0;

		for(int i = 0 ; i < arr.length ; i++){
			current_sum = current_sum + i*arr[i];
			arr_sum = arr_sum + arr[i];  
		}

		max_sum = current_sum;
		int prev_sum = current_sum;
		current_sum = 0;

		for(int i = 1 ;  i< arr.length ; i++){
			current_sum =  prev_sum + arr_sum - (arr_len  * arr[arr_len - i]);
			prev_sum = current_sum;
			if(current_sum>max_sum){
				max_sum = current_sum;
			}
		}
		System.out.println("max array sum: "+max_sum);
	}

	public static void main(String[] args) {
		int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		max_sum(arr);

	}
}