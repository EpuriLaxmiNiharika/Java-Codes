//https://anandabhisheksingh.me/stock-span-problem/

import java.util.*;

class StockSpan{

	static void findStockSpan(int[] stocks,int[] new_arr){

		for(int i = 0 ; i<stocks.length; i++){
			new_arr[i] = 1;
		}

		for(int i = 0; i<stocks.length; i++){

			for(int j = i -1 ; j>=0; j--){
				if(stocks[j]>stocks[i]){
					break;
				}
				else{
					new_arr[i] = new_arr[i] + 1;
				}
			}
		}
	}

	static void printArray(int arr[]){
        System.out.print(Arrays.toString(arr));
    }
     

	public static void main(String[] args) {
		
		int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[]= new int[n];
         
        // Fill the span values in array S[]
        findStockSpan(price, S); 
         
        // print the calculated span values
        printArray(S);

	}
}