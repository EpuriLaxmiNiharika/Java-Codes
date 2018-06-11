class Main{


	static void countStrings(int n,int b, int c){

		if(n==0){
			System.out.println(0);
			return ;
		}

		int[][][] dp= new int[n+1][b+1][c+1];

		for(int i = 0;i<=b;i++){
			for(int j = 0; j<=c;j++){
				//if(i!=0 || j!=0){
					dp[0][i][j] = 1; // rest all chars are a's
				//}
			}
		}

		for(int n1 = 1; n1<=n;n1++){
			for(int i = 0;i<=b;i++){
				for(int j = 0; j<=c;j++){
					  int value = dp[n1-1][i][j];
	            		if (i>=1) value+= dp[n1-1][i-1][j];
	            		if (j>=1) value+= dp[n1-1][i][j-1];
	         		   dp[n1][i][j] = value;
				}
			}

		}
		System.out.println(" "+dp[n][1][2]);

	}

	 public static void main(String[] args) {
		
		countStrings(3,1,2);
	}
}