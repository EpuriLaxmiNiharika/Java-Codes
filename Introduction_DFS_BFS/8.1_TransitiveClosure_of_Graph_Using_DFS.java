//https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/

// For each vertex do DFS Traversal. While DFS TRAVERSAL populate the transitive_closure_matrix

import java.util.*;

class Graph{

	int num_vertices;
	int[][] trans_closure;
	ArrayList<Integer>[] adj_lst;

	Graph(int num_vertices){
		this.num_vertices = num_vertices;

		trans_closure = new int[num_vertices][];

		for(int i = 0; i<trans_closure.length;i++){
			trans_closure[i] = new int[num_vertices];
		}

		for(int i = 0; i<trans_closure.length;i++){
			for(int j = 0; j<trans_closure[i].length;j++){
				trans_closure[i][j] = 0;
			}
		}

		adj_lst = new ArrayList[num_vertices];

		for(int i = 0; i<num_vertices;i++){

			adj_lst[i] = new ArrayList<Integer>();
		}
	}

	void DFS(){

		for(int i = 0; i<num_vertices;i++){
			DFSUtil(i);
		}
		printAdjMatrix();
	}

	void DFSUtil(int startVertex){

		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[num_vertices];
		
		for(int i = 0; i<num_vertices;i++){
			visited[i] = false;
		}

		if(!visited[startVertex]){
			stack.push(startVertex);
			while (!stack.isEmpty()) {
				int popped = stack.pop();

				stack.push(popped);
				visited[popped] = true;
				trans_closure[startVertex][popped] = 1;		 // also captures trans[i][i] = 1		
				if(adj_lst[popped].size()==0){
					stack.pop();
				}

				else{
					int adj_un_visited =0;
					for(int vertex: adj_lst[popped]){
						//trans_closure[startVertex][vertex] = 1; // captures only trans[i][j] = 1, j may not be same as i
						if(!visited[vertex]){
							adj_un_visited ++;
							stack.push(vertex);
						//	visited[vertex] = true;
							break;
						}
					}

					if(adj_un_visited==0){
						stack.pop();
					}
				}
			}
		}
	}

	void addEdge(int src, int dest){ // directed graph

		adj_lst[src].add(dest);
	//	trans_closure[src][dest] = 1;
	}

	void printAdjMatrix(){

		for(int i = 0; i<trans_closure.length;i++){
			for(int j = 0; j<trans_closure[i].length;j++){
				System.out.print(" "+trans_closure[i][j]);
			}
			System.out.println("");
		}
	}

	void printAdjLst(){

		for(int i = 0; i<num_vertices;i++){

		//	System.out.print(i + " --> ");
			for(int element: adj_lst[i]){
				System.out.print(element+" ");
			}
		//	System.out.print("\n");
		}
	}


	public static void main(String[] args) {
		
		Graph g = new Graph(4);
 
        g.addEdge(0, 1);
    	g.addEdge(0, 2);
    	g.addEdge(1, 2);
    	g.addEdge(2, 0);
    	g.addEdge(2, 3);
    	g.addEdge(3, 3);
        
        g.DFS();
	}
}