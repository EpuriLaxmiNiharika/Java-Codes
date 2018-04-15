// Using temp array

class Array_Rotation{
	
	static void rotateLeftToRight(int[] a, int amount){

		int len = a.length;
		int rotate_amount = amount % len;
		int temp[] = new int[ rotate_amount];

		for(int i = 0; i< rotate_amount ; i++){
			temp[i] = a[i];
		}

		for(int i = rotate_amount; i < len ; i++){

			a[i - rotate_amount] = a[i];
		}

		for(int i = 0; i < rotate_amount ; i++){
			a[len - rotate_amount + i] = temp[i];
		}
		printArray(a);
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
