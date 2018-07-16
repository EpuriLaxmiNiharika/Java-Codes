// works for all kinds of graphs

/*
	
	Depth First Traversal can be used to detect cycle in a Graph. 

	DFS for a connected graph produces a tree. There is a cycle in a graph only if there 
	is a back edge present in the graph. A back edge is an edge that is from a node to itself 
	(selfloop) or one of its ancestor in the tree produced by DFS


	The idea is to do DFS of given graph and while doing traversal, assign one of the below three colors to every vertex.

	WHITE : Vertex is not processed yet.  Initially
	        all vertices are WHITE.

	GRAY : Vertex is being processed (DFS for this 
	       vertex has started, but not finished which means
	       that all descendants (ind DFS tree) of this vertex
	       are not processed yet (or this vertex is in function
	       call stack)

	BLACK : Vertex and all its descendants are 
	        processed.

	While doing DFS, if we encounter an edge from current 
	vertex to a GRAY vertex, then this edge is back edge 
	and hence there is a cycle.


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

        int[] color_nodes = new int[num_vertices];

        Arrays.fill(color_nodes,0); // 0 - white, 1- grey, 2- black
         
    
        for (int i = 0; i < num_vertices; i++){
            if(color_nodes[i]==0){
	            if (isCyclic(i, color_nodes))
	                return true;
	        }
	    }
 
        return false;

	}

	boolean isCyclic(int src,  int[] color_nodes){

		color_nodes[src] = 1; // marking a node as grey node

		for(int i = 0; i<adj_lst[src].size();i++){

			int node = adj_lst[src].get(i);
			if(color_nodes[node]==1){
				return true;
			}
			if(color_nodes[node]==0 && isCyclic(node,color_nodes)){ // first time  "node" is explored via "i" ( initially we have color of node = 0)
																	// means via i you are reaching node from "node" that is in stack.
				return true;
			}
		}

		color_nodes[src] = 2;

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