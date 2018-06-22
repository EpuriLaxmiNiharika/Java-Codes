class Node{

	int value;

	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}


class BST{

	Node root;

	static boolean isSameBST(int[] a, int[] b, int start1, int start2, int min, int max){

		if(start1> a.length && start2>b.length){
			return  true;
		}

		int i = start1;
		for(i = start1; i<a.length;i++){
			if(a[i]>=min && a[i]<=max){
				break;
			}
		}

		int j = start2;
		for(j = start2; j<b.length;j++){
			if(b[j]>=min && b[j]<=max){
				break;
			}
		}

		if(i==a.length && j == b.length){
			return true;
		}

		if (((i==a.length)^(j==b.length)) || a[i]!=b[j])
       		return false;

       	return isSameBST(a,b,i+1,j+1,min,a[i]-1) && isSameBST(a,b,i+1,j+1,a[i]+1,max);
	}

	public static void main(String[] args) {
		
		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
  	 	int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};

   		if(isSameBST(a, b, 0,0,Integer.MIN_VALUE, Integer.MAX_VALUE)){
            System.out.println("BSTs are same");
        }
        else{
        	System.out.println("BSTs not same");
        }
	}
}