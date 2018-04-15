class FindMinElement{

 static int findMinElement(int[] arr, int start, int end){
	
    int middle = (start+end)/2;

    if(start > end){
		return -1;
	}

    if(arr[start]<arr[end]){
    	 System.out.println("min element:"+arr[start]);
         return arr[start];
    }

    if(middle > start && arr[middle]< arr[middle-1]){
        System.out.println("min element:"+arr[middle]);
        return arr[middle];
    }

    if(arr[end] >= arr[middle]){ // arr[middle+1..end] is sorted // 8 9 1 2 3 4 5 6 7
        
        return findMinElement(arr,start,middle-1);
    }
    else{
        return findMinElement(arr,middle+1,end);
    }

}

public static void main(String args[]){
	int arr[] = { 8, 9, 1, 2, 3, 4, 5, 6, 7};
	findMinElement(arr,0,arr.length-1);
 }
}

