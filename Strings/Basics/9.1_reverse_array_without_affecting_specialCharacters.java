class Main{


	static void customReverseArray(char[] array){

		int left = 0; 
		int right = array.length -1;


		for(int i = 0; i<array.length;i++){
			System.out.print(array[i]);
		}

		System.out.println("\nafter custom reverse\n");

		while (left<right) {
			
			if(!Character.isAlphabetic(array[left])){
				left++;
			}
			
			else if(!Character.isAlphabetic(array[right])){
				right--;
			}

			else{
				char temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				
				left ++;
				right--;
			}
		}

		for(int i = 0; i<array.length;i++){
			System.out.print(array[i]);
		}
	}

	public static void main(String[] args) {
		String str = "@a!!!b.c.d,e'f,ghi!";
        char[] charArray = str.toCharArray();
		customReverseArray(charArray);
	}
}