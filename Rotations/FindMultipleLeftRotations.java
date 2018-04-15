/*

Step 1 : Copy the entire array two times in temp[0..2n-1] array.
Step 2 : Starting position of array after k rotations in temp[] will be k % n. We do k
Step 3 : Print temp[] array from k % n to k % n + n.

*/

class findMultipleLeftRotations {

static void printArray(int[] arr, int start, int end){

	for(int i = start; i<=end; i++){
		System.out.print(" "+ arr[i]);
	}
	System.out.println("");
}

static void findMultipleLeftRotations(int[] arr, int[] rotations){

	int temp[] = new int[arr.length * 2];
	for(int i = 0; i< arr.length; i++){
		temp[i] = arr[i];
		temp[arr.length + i] = arr[i];
	}

	for(int i = 0; i< rotations.length; i++){
		int rotate_amount = rotations[i];
		printArray(temp, rotate_amount, arr.length + rotate_amount);
	}

}
public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9};
		int rotations[] = {2,3,4};
		findMultipleLeftRotations(arr,rotations);
	}	
}