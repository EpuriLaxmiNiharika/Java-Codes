// https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
// First Watch Tushar roy video on Kosaraju algorithm
/*
	
	It is an application of Kosaraju algorithm.
	Mother vertex appear in the top of stack after DFS traversal

	algo:

	
    Do DFS traversal of the given graph. While doing traversal keep track of last finished vertex ‘v’. This step takes O(V+E) time.
    If there exist mother vertex (or vetices), then v must be one (or one of them). Check if v is a mother vertex by doing DFS/BFS from v. This step also takes O(V+E) time.


*/


import java.util.*;

class Graph{

	LinkedList<Integer> adj_lst[];
	int num_vertices;
	
	public Graph(int vertices){
		this.num_vertices = vertices;

		adj_lst = new LinkedList[vertices];

		for(int i = 0; i<vertices;i++){
			adj_lst[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest){ // directed graph

		adj_lst[src].add(dest);

	}

	void printAdjLst(){

		for(int i = 0; i<num_vertices;i++){

			System.out.print(i + " --> ");
			for(int element: adj_lst[i]){
				System.out.print(element+" ");
			}
			System.out.print("\n");
		}
	}


	void findMotherVertex(){ // If there is Mother vertex, then it would be the last finished vertex while DFS Traversal.

		boolean[] visited = new boolean[num_vertices];

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> order_finished_vertices = new Stack<Integer>();


		for (int i = 0;i<num_vertices ;i++ ) {
			visited[i] = false;
		}
	

		for(int i = 0; i< num_vertices;i++){
			DFSTraversal(i,visited,stack,order_finished_vertices);
		}


	//	printStack(order_finished_vertices);

		int motherVertex = order_finished_vertices.peek(); // PROPOSED MOTHER VERTEX.

		// DO DFS TRAVERSAL FROM MOTHER VERTEX AND SEE IF ALL VERTICES ARE VISITED FROM THERE


		for (int i = 0;i<num_vertices ;i++ ) {
			visited[i] = false;
		}

		DFSTraversal(motherVertex,visited,stack,order_finished_vertices);


		for (int i = 0;i<num_vertices ;i++ ) {
			if(!visited[i]){
				System.out.println("No mother vertex found");
				return ;
			}
		}

		System.out.println("Mother vertex: "+motherVertex);
	}

	// KEEPS TRACK OF ORDER OF VERTICES FINISHED VISITING.
	// A vertex would be finished, when it's all children are finished visiting.
	// It's children would be finished when their children are finished visiting.
	// So, This would be a recursive thing


	// Stack - stack - Maintains list of vertices whose children are not completely explored
	// Stack - order_finished_vertices - Maintains list of vertices in decreasing order of finish times.

	void DFSTraversal(int startVertex,boolean[] visited, Stack<Integer> stack,Stack<Integer> order_finished_vertices){ // we might visit the same vertex again and again while traversing. So maintain list of visited nodes
		if(!visited[startVertex]){
			visited[startVertex] = true;
			stack.push(startVertex);
			while(stack.size()>0){
				int popped = stack.pop();
				stack.push(popped); // instead can do stack.peek()

				if(adj_lst[popped].size()==0){
					order_finished_vertices.push(popped);
					stack.pop();
				}
				
				else{
					int vertices_not_visited = 0;
					for(Integer vertex: adj_lst[popped]){
						if(!visited[vertex]){
							stack.push(vertex);
							visited[vertex] = true;
							vertices_not_visited++;
							break;
						}
					}

					if(vertices_not_visited==0){
						stack.pop();
						order_finished_vertices.push(popped);
					}
				}
			}	
		}

	}


	public void printStack(Stack<Integer> stack){
	//	System.out.println("---\n");
		for(Integer i: stack){
			System.out.print(" "+i);
		}
	//	System.out.println("\n \n");
	}

	public boolean stackContainsElement(Stack<Integer> stack, int element){

		for(Integer i: stack){
			if(i==element){
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		
		Graph g = new Graph(7);
       
        g.addEdge(0, 1);
    	g.addEdge(0, 2);
    	g.addEdge(1, 3);
    	g.addEdge(4, 1);
    	g.addEdge(6, 4);
    	g.addEdge(5, 6);
    	g.addEdge(5, 2);
    	g.addEdge(6, 0);

		g.findMotherVertex();
	}
}

