class Array_Rotation{
	
	static void rotateLeftToRight(int[] a, int amount){

		for(int i = 0 ; i< amount; i++){
			rotateByOne(a);
		}
		
		printArray(a);
	}

	static void rotateByOne(int []arr){

		int temp = arr[0];
		for(int i = 0; i< arr.length-1; i++){
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp;
	}

	public static void printArray(int[] arr){

		for(int i = 0; i< arr.length; i++){
			System.out.print(" "+arr[i]);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		int rotate_amount = 3;
		rotateLeftToRight(arr,rotate_amount);
	}
}

