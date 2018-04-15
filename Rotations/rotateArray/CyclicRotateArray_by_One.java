class CyclicRotateArray_by_One {
	
	static void cyclic_rotate_by_one(int[] arr){
		int temp = arr[arr.length-1];
		for(int i = arr.length -1 ; i>=1; i--){
			arr[i] = arr[i-1];
		}

		arr[0] = temp;
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
		cyclic_rotate_by_one(a);
	}
}