class FindMaxSum{

	static int findSum(int[] arr){
		int sum =0;
		for(int i = 0; i< arr.length; i++){
			sum = sum + i * arr[i];
		}
		return sum;
	}

	static void maxSum(int[] arr){

		int len = arr.length;
		int sum,max_sum = 0;
		for(int i = 0; i< len ; i++){
			if(i ==0){
				sum=max_sum = findSum(arr);	
			}
			else{
				jugglingAlgo(arr, 1, len);
				sum = findSum(arr);
				if(sum> max_sum){
					max_sum = sum;
				}
			}

		System.out.println("max sum is:" + max_sum);
	
		}

		System.out.println("max sum is:" + max_sum);
	}

	static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i <size; i++)
            System.out.print(arr[i] + " ");

        System.out.println("");
    }

	static int gcd(int a, int b){

		if(b==0){
			return a;
		}
		return gcd(b, a%b);
	}

	static void jugglingAlgo(int[] arr , int amount, int size){

		int num_sets = gcd(size, amount);
		for(int i = 0; i<num_sets; i++){
			int temp = arr[i];
			int k = i;
			while (1!=0) {
				arr[k %size] = arr[(k + amount) % size];
				k = k + amount;
				if(k % size == i){
					k = k - amount;
					arr[k%size] = temp;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		maxSum(arr);
	}
}