class FindElementInSortedRotatedArray{
	
	static int findArrayBeginning_in_sortedRotatedArray(int[] arr){

		for(int i = 1 ; i< arr.length -1 ; i ++){
			if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
				return i;
			}
		}
		return 0;
	}

	static int findElementIn_SortedRotated_array(int [] arr, int element){

		int sorted_array_begin_index = findArrayBeginning_in_sortedRotatedArray(arr);
		int leftArray[] = new int[sorted_array_begin_index]; // sorted
		int rightArray[] = new int[arr.length - sorted_array_begin_index]; // sorted

		for(int i = 0; i< sorted_array_begin_index;i++){
			leftArray[i] = arr[i];
		}

		for(int i = 0; i< arr.length - sorted_array_begin_index ; i++){
			rightArray[i] = arr[sorted_array_begin_index+i];
		}

		if(arr[0]==element){
			return 0;
		}

		else if(arr[0] > element){
			int index = binarySearch(rightArray, element);
			if(index == -1){
				System.out.println("element not found");
				return -1;
			}
			System.out.println("element found at index: " + (index + sorted_array_begin_index));;
			return index;
		}

		else{
			int index = binarySearch(leftArray,element);
			if(index == -1){
				System.out.println("element not found");
				return -1;
			}
			System.out.println("element found at index: " + (index));;
			return index + sorted_array_begin_index;
		}

	}


	static int binarySearch(int[] arr, int element){
		int left = 0;
		int right = arr.length-1;
		int middle = (left+right)/2;

		for(int i = left; i <=right ; i ++ ){
			
			if(arr[middle] == element){
				return middle;
			}

			else if(arr[middle] < element){
				left = middle + 1;
			}
			else{
				right = middle -1;
			}

			middle = (left+right)/2;
		}

		return -1;
	}


	public static void printArray(int[] arr){

		for(int i = 0; i< arr.length; i++){
			System.out.print(" "+arr[i]);
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
 		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};		
 		findElementIn_SortedRotated_array(arr,3);
	}
}