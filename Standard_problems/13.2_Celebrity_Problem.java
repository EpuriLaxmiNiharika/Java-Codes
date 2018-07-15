/*

	Method (Using Stack)

	We have following observation based on elimination technique (Refer Polya’s How to Solve It book).

	    If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
	    If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be celebrity.
	    Repeat above two steps till we left with only one person.
	    Ensure the remained person is celebrity. (Why do we need this step?)
		
		// because the remained person might have been considered late(added later to the stack), 
		and the all the persons discarded(people popped from stack) before might have not known this potential celebrity.

	We can use stack to verity celebrity.

	    Push all the celebrities into a stack.
	    Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B).
	    Push the remained person onto stack.
	    Repeat step 2 and 3 until only one person remains in the stack.
	    Check the remained person in stack doesn’t have acquaintance with anyone els

*/



import java.util.*;

class Celebrity{

	static void findCelebrity(int[][] graph){

		Stack<Integer> people = new Stack<Integer>();

		for(int i = 0; i<graph.length;i++){

			people.push(i);
		}


		while (people.size()>1) {
			
			int person1 = people.pop();
			int person2 = people.pop();

			if(knows(graph,person1,person2)){ // person1 can't be celebrity

				people.push(person2);
			}

			else{
				people.push(person1); // person1 can be potential celebrity
			}
		}

		int potential_celeb = people.pop();

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
		

		int  Matrix[][] = {
							  {0, 0, 0, 1, 0},
		                      {0, 0, 0, 1, 0},
		                      {0, 0, 0, 1, 0},
		                      {0, 0, 0, 0, 0},
		                      {0, 0, 0, 1, 0}
						  };

		findCelebrity(Matrix);				  

	}
}