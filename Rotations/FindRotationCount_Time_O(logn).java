// Using modified binary search find the least element index
// count = index - 0 = index

/*
Algo:
Binarysearch(arr, start, end){
	if(arr[start]< arr[end]) return start
	if(arr[mid] < arr[mid-1]) return mid
	if(arr[start] < arr[mid]) // means arr[start..mid] is sorted{
		Binarysearch(arr, mid+1, end){	
	}
	else{ // means arr[mid..end] is sorted
		Binarysearch(arr, start, mid-1){
	}
}
*/

class FindRotationCount{
	
	static int modifiedBinarySearch(int[] arr, int start, int end){
		
		int middle = (start + end)/2;
		
		if(start > end){
			System.out.println(0);
			return 0;
		}


		if(arr[start] < arr[end]){
			System.out.println(start);
			return start;
		}
		
//		System.out.println("start" + start +" end " + end + " middle "+middle);

		if(middle > start && arr[middle] < arr[middle -1]){
			System.out.println(middle);
			return middle;
		}
		

		if(arr[end] > arr[middle]){ // 3 4 5 1 2
			return modifiedBinarySearch(arr, start, middle-1);
		}

		else{ // 7 8 1 2 3 4 5
			return modifiedBinarySearch(arr, middle+1,end);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 8, 9, 1, 2, 3, 4, 5, 6, 7};
		modifiedBinarySearch(arr,0,arr.length-1);
	}
}
