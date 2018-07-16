import java.util.*;

class Graph{

	LinkedList<Integer> adj_lst[];

	int num_vertices;
	Graph(int vertices){
		this.num_vertices = vertices;

		adj_lst = new LinkedList[vertices];

		for(int i = 0; i<vertices;i++){
			adj_lst[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest){

		adj_lst[src].add(dest);
		adj_lst[dest].add(src);

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

	public static void main(String[] args) {
		
		Graph graph =new Graph(5);
		graph.addEdge(1,2);
		graph.addEdge(3,4);
		graph.addEdge(1,4);
		graph.addEdge(1,3);
		graph.addEdge(2,3);
		graph.addEdge(0,4);
		graph.printAdjLst();
	}
}

