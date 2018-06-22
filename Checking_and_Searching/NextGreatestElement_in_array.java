class Main{

	static void findNextGreatestElement(int[] arr){

		int length = arr.length;
		int max_so_far = arr[length-1];

		System.out.println(arr[length-1]+"----Not found");
		for(int j = arr.length-2;j>=0;j--){

			if(arr[j]<max_so_far){
				System.out.println(arr[j]+"----"+max_so_far);
			}
			else{
				System.out.println(arr[j]+"----Not found");
			}

			if(max_so_far<arr[j]){
				max_so_far = arr[j];
			}
		}
	}

	public static void main(String[] args) {
		
		int[] arr = new int[]{3, 4, 20, 6,2,1,7};
		findNextGreatestElement(arr);
	}
}