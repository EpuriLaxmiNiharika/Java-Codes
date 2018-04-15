class Find_a_Pair_with_given_sum {

	static int findArrayBeginning_in_sortedRotatedArray(int[] arr){

		for(int i = 1 ; i< arr.length -1 ; i ++){
			if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
				return i;
			}
		}
		return 0;
	}

	static void findPairWithGivenSum(int[] arr, int sum){ // modification to find pair with given sum in sorted array.
		int leftPtr = findArrayBeginning_in_sortedRotatedArray(arr);
		int rightPtr = leftPtr -1;
		if(leftPtr==0){
			rightPtr = 0;
		}

		while (leftPtr!=rightPtr) {
			
			if((arr[leftPtr%arr.length] + arr[rightPtr%arr.length]) == sum){
				System.out.println("indices: " + leftPtr + " and "+rightPtr);
				return;
			}
			else if((arr[leftPtr % arr.length] + arr[rightPtr%arr.length]) >sum){
				rightPtr = (rightPtr-1)%arr.length;
			}
			else{
				leftPtr = (leftPtr+1)%arr.length; 
			}
		}
		System.out.println("No pair of values found!!");
	}

	public static void main(String[] args) {
	
	int arr[] = {3,5,6,1,2};
	findPairWithGivenSum(arr,6);

	}	
}