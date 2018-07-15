import java.util.*;

class StockSpan{

	static void findStockSpan(int[] stocks,int[] new_arr){

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(0); 
         
        // Span value of first element is always 1
        new_arr[0] = 1;

        for(int i = 1; i<stocks.length;i++){

        	int current_stock_price = stocks[i];

        	while (!stack.isEmpty()) {
        		if(stocks[stack.peek()] <= current_stock_price){
        			stack.pop();
        		}
        		else{
        			break;
        		}
        	}

        	if(stack.isEmpty()){
        		new_arr[i] = i+1;
        	}
        	else{
        		new_arr[i] = i - stack.peek();
        	}

        	stack.add(i);
        }
	}

	static void printArray(int arr[]){
        System.out.print(Arrays.toString(arr));
    }
     

	public static void main(String[] args) {
		
		int price[] = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;
        int S[]= new int[n];
         
        // Fill the span values in array S[]
        findStockSpan(price, S); 
         
        // print the calculated span values
        printArray(S);

	}
}