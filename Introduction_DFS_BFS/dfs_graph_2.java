// works for connected graph

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

	void DFS(int src){

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(src);
		boolean visited[] = new boolean[num_vertices];
		visited[src] = true; // visited[i] = true if when vertex i is added to stack
		System.out.print(src+" ");

		while (!stack.isEmpty()) {
			
			int popped = stack.peek();

			int i = 0;

			for(i = 0; i<adj_lst[popped].size();i++){

				int end = adj_lst[popped].get(i);

				if(!visited[end]){
					System.out.print(end+" ");
					stack.push(end);
					visited[end] = true;
					break;
				}
			}

			if(i==adj_lst[popped].size()){
				visited[popped]=true;
				stack.pop();
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

		graph.DFS(2);	
	}	
}