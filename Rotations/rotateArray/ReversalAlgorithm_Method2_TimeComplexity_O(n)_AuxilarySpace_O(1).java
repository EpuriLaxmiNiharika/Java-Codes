/*

Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is:
Reverse A to get ArB. // Ar is reverse of A 
Reverse B to get ArBr. // Br is reverse of B 
Reverse all to get (ArBr) r = BA.

For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
A = [1, 2] and B = [3, 4, 5, 6, 7]
Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]


*/



class ReversalAlgorithm_Method2 {
	
	static void reversalAlgo(int[] arr, int amount){


		for(int i = 0 ; i < amount/2 ;i++){
			int temp = arr[i];
			arr[i] = arr[amount -1 -i];
			arr[amount-1-i] = temp;
		}

		for(int i = 0; i< (arr.length - amount)/2; i++){
			int temp = arr[i+amount];
			arr[i + amount] = arr[arr.length -1 - i];
			arr[arr.length -1 - i] = temp;
		}

		for(int i = 0; i< arr.length/2 ; i ++){
	//		System.out.print("wa");
			int temp = arr[i];
			arr[i] = arr[arr.length-1 - i];
			arr[arr.length -1 -i] = temp;
		}

		
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
		int rotate_amount = 2;
		reversalAlgo(a,rotate_amount);
	}
}