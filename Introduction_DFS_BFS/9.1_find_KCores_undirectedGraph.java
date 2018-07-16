//https://www.geeksforgeeks.org/find-k-cores-graph/

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
		adj_lst[dest].add(src);

	}

	void printAdjLst(int k){

		for(int i = 0; i<num_vertices;i++){
			if(adj_lst[i].size()>=k){
				System.out.print(i + " --> ");
				for(int element: adj_lst[i]){
					System.out.print(element+" ");
				}
				System.out.print("\n");
			}
			
		}
	}

	void DFSTraversal(int startVertex, Stack<Integer> stack, boolean visited[],int[] degrees,int k){ // we might visit the same vertex again and again while traversing. So maintain list of visited nodes

		stack.push(startVertex);

		while(!stack.isEmpty()){
		
			int popped = stack.pop();

			visited[popped] = true;

	//		System.out.println("popped: "+popped + " degree: "+degrees[popped]);
			if(degrees[popped]<k){
				degrees[popped] = 0;

				for(int i = 0; i<  adj_lst[popped].size();i++){
					int vertex = adj_lst[popped].get(i);
	//				System.out.println(popped+"----"+vertex);
					stack.push(vertex);
					degrees[vertex]  = degrees[vertex] -1;
					for(int i1 = 0; i1<adj_lst[vertex].size();i1++){
						if(adj_lst[vertex].get(i1)==popped){
							adj_lst[vertex].remove(i1);
							break;
						}
					}
				}

				adj_lst[popped].clear();
			}
		}
	//	printAdjLst();
		
	}

	int num_visited_vertices(boolean[] visited){

		int un_visited = 0;
		for(int i = 0; i<num_vertices;i++){
			if(!visited[i]){
				un_visited++;
			}
		}
		return un_visited;
	}
	void printStack(Stack<Integer> s){
		System.out.print("\n");
		for(int element:s ){
			System.out.print(" "+element);
		}
		System.out.print("\n");
	}


	void find_k_cores_graph(int k){


		if(num_vertices<=0){
			return;
		}

		for(int i = 0; i<num_vertices;i++){

		//	System.out.println("round====== "+(i+1));
			int[] degrees = new int[num_vertices];
		
			for(int i1 = 0; i1<num_vertices;i1++){
				degrees[i1] = adj_lst[i1].size();
			}

			int least_degree_vertex = findLeastDegreeVertex(k,degrees);
			
			if(least_degree_vertex<0) break;
			
	//		System.out.println("least_degree:"+least_degree_vertex);

			boolean[] visited = new boolean[num_vertices];
			
			for (int i1 = 0;i1<num_vertices ;i1++ ) {
				visited[i1] = false;
			}

			Stack<Integer> stack = new Stack<Integer>();

			DFSTraversal(least_degree_vertex,stack,visited,degrees,k);
		}

		printAdjLst(k);	
	}

	public int findLeastDegreeVertex(int k,int[] degrees){

		int least_degree = Integer.MAX_VALUE;
		int least_degree_vertex = -1;

		for(int i = 0; i<num_vertices;i++){
			if(degrees[i]<least_degree && degrees[i]>0){
				least_degree = degrees[i];
				least_degree_vertex = i;
			}
		}

		if(least_degree>k){
			return -1;
		}
		return least_degree_vertex;
	}

	public static void main(String[] args) {
		
		Graph g1 = new Graph(9);
	    g1.addEdge(0, 1);
	    g1.addEdge(0, 2);
	    g1.addEdge(1, 2);
	    g1.addEdge(1, 5);
	    g1.addEdge(2, 3);
	    g1.addEdge(2, 4);
	    g1.addEdge(2, 5);
	    g1.addEdge(2, 6);
	    g1.addEdge(3, 4);
	    g1.addEdge(3, 6);
	    g1.addEdge(3, 7);
	    g1.addEdge(4, 6);
	    g1.addEdge(4, 7);
	    g1.addEdge(5, 6);
	    g1.addEdge(5, 8);
	    g1.addEdge(6, 7);
	    g1.addEdge(6, 8); 
		g1.find_k_cores_graph(3);
	}
}

