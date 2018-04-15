class ReversalAlgorithm_Method1 {
	
	static void reversalAlgo(int[] arr, int amount){

		for(int i = 0; i< arr.length/2 ; i++){  // reversing array

			int temp = arr[i];
			arr[i] = arr[arr.length - i -1];
			arr[arr.length -1 - i] = temp;
		}


		for(int i = 0; i< (arr.length-amount)/2 ; i ++){ // reversing array from 0 - (arr.length-amount)
			int temp = arr[i];
			arr[i] = arr[arr.length-amount -1 -i];
			arr[arr.length-amount-1-i] = temp;
		}

		for(int i = 0 ; i < amount/2 ;i++){ // reversing array from arr.length - amount + 1 to arr.length
			int index = arr.length - amount + i;
			int temp = arr[index];
			arr[index] = arr[arr.length - i -1];
			arr[arr.length -i -1] = temp;
		}

		printArray(arr);
	}

	public static void printArray(int[] arr){

		for(int i = 0; i< arr.length; i++){
			System.out.print(" "+arr[i]);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int rotate_amount = 2;
		reversalAlgo(a,rotate_amount);
	}
}