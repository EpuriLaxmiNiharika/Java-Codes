// Find the index of first smallest (least element in arr) 
// rotation count = index - 0 = index 


class FindRotationCount{
	
	static void findRotationCount(int[] arr){
		int count = 0;
		int ele = arr[0];
		for(int i = 1; i<arr.length; i++){
			if(arr[i] < ele){
				count = i;
				break;
			}
		}

		System.out.println("count: "+count);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
		findRotationCount(arr);
	}
}