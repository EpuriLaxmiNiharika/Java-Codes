//    For n disks, total 2^n – 1 moves are required.
//     For n disks, total 2^(n+1) – 1 function calls are made.

class TowersOfHanoi{

	static void towers_hanoi(char from , char to, char aux, int n){

		if(n==1){
			System.out.println("moving "+n+" from "+from+"---> to "+to);
			return;
		}

		towers_hanoi(from,aux,to,n-1);

		System.out.println("moving "+n+" from "+from+"---> to "+to);

		towers_hanoi(aux,to,from,n-1);
	}

	public static void main(String[] args) {
		
		towers_hanoi('A','C','B',4);
	}
}