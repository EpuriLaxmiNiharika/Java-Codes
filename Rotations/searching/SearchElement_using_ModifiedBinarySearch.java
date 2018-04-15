class ModifiedBinarySearch  {
	
	static int modifiedBinarySearch(int[] arr, int startIndex, int endIndex, int element){

		if(startIndex >endIndex){
			return -1;
		}

		int middle = (startIndex + endIndex)/2;

		if(arr[middle]==element){
			System.out.println(middle);
			return middle;
		}

		if(arr[middle] >=arr[startIndex]){ // arr[low.. middle] is sorted
			if(arr[middle] > element && element >= arr[startIndex]){ // element lies in arr[low..middle-1]
				return modifiedBinarySearch(arr, startIndex,middle-1, element);
			}
			else{
				return modifiedBinarySearch(arr, middle+1, endIndex, element);
			}
		}

		else { // arr[middle .. end ] is sorted
			if(arr[middle] < element && element <= arr[endIndex]){
				return modifiedBinarySearch(arr, middle+1, endIndex, element);
			}
			else{

				return modifiedBinarySearch(arr,startIndex,middle-1,element);
			}
		}
		
	
	}	
	

	

	public static void main(String[] args) {
		
		//int arr[] = {2,3,4,5,1};
		int arr[] = {4,5,6,7,8,10,1,2,3};
		modifiedBinarySearch(arr, 0,arr.length-1,10);

	}


}

// 1 2 3 4 5  -- midd1e >

// 4 5 1 2 3 -- middle <

// 3 4 5 1 2

//  2 3 5 1 2


// 2 3 4 5 1  -- middle > ---
