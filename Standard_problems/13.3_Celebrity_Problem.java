/*

	Method (Using Two pointers)

	We have following observation based on elimination technique (Refer Polya’s How to Solve It book).

	    If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
	    If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be celebrity.
	    Repeat above two steps till we left with only one person.
	    Ensure the remained person is celebrity. (Why do we need this step?)
		
		// because the remained person might have been considered late(added later to the stack), 
		and the all the persons discarded(people popped from stack) before might have not known this potential celebrity.

	
		The idea is to use two pointers, one from start and one from the end. 
		Assume the start person is A, and the end person is B. 
		If A knows B, then A must not be the celebrity. Else, B must not be the celebrity. 

		We will find a celebrity candidate at the end of the loop. Go through each person again and check whether this is the celebrity.
*/



import java.util.*;

class Celebrity{

	static void findCelebrity(int[][] graph){

		int A = 0;
		int B = graph.length-1;

		while (A<B) {
			
			if(knows(graph,A,B)){ // if A knows B then A is not potential celebrity
				A++;
			}

			else {
				B--; // We are moving one step closer in making A as  celebrity		
			}	
		}

		int potential_celeb = A;

		for(int i = 0; i<graph.length;i++){ // checking if potential celeb is actual celeb or not

			if(i!=potential_celeb && (knows(graph,potential_celeb,i) || !knows(graph,i,potential_celeb))){
				
				System.out.println("No potential_celeb");
				return ;
			}
		}
		System.out.println("Celebrity ID: "+potential_celeb);
		return  ;
	}

	static boolean knows(int[][] graph, int person1, int person2){ // checking if person1 knows person2

		if(graph[person1][person2]==1){
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		

		int  Matrix[][] =  {
							{0, 0, 1, 0},
	                     	{0, 0, 1, 0},
	                     	{0, 0, 0, 0},
	                     	{0, 0, 1, 0}
						  };

		findCelebrity(Matrix);				  

	}
}