import java.util.*;

// https://www.youtube.com/watch?v=utE_1ppU5DY

class JugglingAlgorithm_ArrayRotations {
	
	static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
    // Driver program to test above functions

// Basic gcd algo
/*
    static int gcd(int a, int b){

    	int gcd = 1;
    	int min = (a<b)? a : b;
	int max = (a>b)? a:b;
	if(max%min ==0) return b;
    /*	for(int i = 2; i<= min/2;i ++){
    		if((a%i == 0) && (b%i ==0)){
    			gcd = i;
    		}
    	} 
    	return gcd; */
/*
    }

*/

// Euclidean basic GCD Algo

 /* 	
  	static int gcd1(int a, int b){

    	if(b==0){
    		return a;
    	}

    	return gcd1(b,a-b);
    }

*/

// Euclidean advanced GCD Algo

    static int gcd(int a, int b){

    	if (b == 0)
        	return a;
    	
    	return gcd(b, a % b);
    }

    static void leftRotate(int[] arr, int amount , int size){

    	int numberOfsets = gcd(size, amount);
    //	System.out.println("numberOfsets"+numberOfsets);
    	for(int i = 0 ; i < numberOfsets ; i++){
    		int temp = arr[i];
    		int k = i;
    		while (1!=0) {
    			arr[k %size] = arr[(k + amount)%size];
    			k = k+amount;
			System.out.println("k is"+k);
    			if(k%size == i){
    				k = k - amount;
    				arr[k%size] = temp;
    				break;
    			}
    		}
    	}
    	printArray(arr,size);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        leftRotate(arr, 1, 6);
    //  	printArray(arr, 7);
    }
}
