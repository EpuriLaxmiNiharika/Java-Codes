// works for all kinds of graph(connected and disconected)

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

	void DFS(){

		boolean visited[] = new boolean[num_vertices];

		for(int i = 0; i<num_vertices;i++){

			if(!visited[i]){
				DFSUtil(i, visited);
			}
		}
	}

	void DFSUtil(int src, boolean[] visited){

		visited[src] = true;

		System.out.print(src+" ");

		for(int i = 0; i<adj_lst[src].size();i++){

			int node = adj_lst[src].get(i);
			if(!visited[node]){
				DFSUtil(node,visited);
			}
		}
	}

	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(2,0);
		graph.addEdge(2,3);	
		graph.addEdge(1,2);
		graph.addEdge(3,3);

		graph.DFS();	
	}	
}