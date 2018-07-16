// works for all kinds of graphs

/*
	
	To detect a back edge, we can keep track of vertices currently in recursion stack of function 
	for DFS traversal. If we reach a vertex that is already in the recursion stack, 
	then there is a cycle in the tree. The edge that connects current vertex to the vertex in the 
	recursion stack is a back edge. We have used recStack[] array to keep track of vertices in the recursion stack.


	Just by looking the nodes that are  visited doesnt work, for example 

	1->2->3
	6->5->2->3

*/


import java.util.*;

class Graph{
	int num_vertices;
	ArrayList<Integer> adj_lst[];

	Graph(int num_vertices){

		this.num_vertices = num_vertices;
		adj_lst = new ArrayList[num_vertices];
		for(int i = 0; i<num_vertices;i++){
			adj_lst[i] = new ArrayList<Integer>();
		}
	}

	void addEdge(int src, int dest){

		adj_lst[src].add(dest);
	}

	boolean DFS(){

		boolean[] visited = new boolean[num_vertices];
        boolean[] recStack = new boolean[num_vertices];
         
         
        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < num_vertices; i++)
            if (isCyclic(i, visited, recStack))
                return true;
 
        return false;

	}

	boolean isCyclic(int src, boolean[] visited, boolean[] recursionStack ){


		if(recursionStack[src]){ // check if the node is already present in recursion stack
			return true;
		}


		if(visited[src]){ // if you are visiting the already visited node ( the node that is already popped from recursion stack)
			return false;
		}


		visited[src] = true;

		recursionStack[src] = true;

		for(int i = 0; i<adj_lst[src].size();i++){

			int node = adj_lst[src].get(i);
			if(isCyclic(node,visited,recursionStack)){
				return true;
			}
		}

		recursionStack[src] = false;
		return false;
	}

	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		
		graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
         

		if(graph.DFS()){
			System.out.println("cycle found");
		}	
		else{
			System.out.println("cycle not found");
		}	
	}	
}	