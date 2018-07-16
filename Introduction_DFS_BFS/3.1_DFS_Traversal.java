//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

// I am getting different answer than the link because.. in geeks.. after one adding element to stack they are visiting al its child nodes. Then they are repeating the same approach for rest of the child of the first element added

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

		//adj_lst[src].addFirst(dest); // to get geeks answer. add the edges to the front of linkedlist
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

	void DFSTraversal(int startVertex){ // we might visit the same vertex again and again while traversing. So maintain list of visited nodes

		if(num_vertices<=0){
			return;
		}

		boolean[] visited = new boolean[num_vertices];

		for (int i = 0;i<num_vertices ;i++ ) {
			visited[i] = false;
		}
	
		Stack<Integer> stack = new Stack<Integer>();


		stack.push(startVertex);
		visited[startVertex] = true;

		while(!stack.isEmpty()){
			int popped = stack.pop();
			System.out.print(" "+popped);
			for(int vertex: adj_lst[popped]){
				if(!visited[vertex]){
					stack.push(vertex);
					visited[vertex] = true;
				}
			}
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
		g.DFSTraversal(2);
	}
}

