class Main{

	static void findNextGreaterElement(int[] arr){

		for(int i = 0; i<arr.length;i++){
			int ele = arr[i];
			int j = i+1;
			for(j = i+1;j<arr.length;j++){
				if(arr[j]>ele){
					System.out.println(ele+"----"+arr[j]);
					break;
				}
			}
			if(j==arr.length){
				System.out.println(ele+"--- No greater ele found");
			}
		}
	}

	public static void main(String[] args) {
		
		int[] arr = new int[]{11, 13, 21, 3};
		findNextGreaterElement(arr);
	}
}