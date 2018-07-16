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

	void BFSTraversal(int startVertex){ // we might visit the same vertex again and again while traversing. So maintain list of visited nodes

		if(num_vertices<=0){
			return;
		}

		boolean[] visited = new boolean[num_vertices];

		for (int i = 0;i<num_vertices ;i++ ) {
			visited[i] = false;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(startVertex);
		visited[startVertex] = true;
		while(!queue.isEmpty()){
			int dequeue = queue.remove();
			System.out.print(" "+dequeue);
			for(int vertex: adj_lst[dequeue]){
				if(!visited[vertex]){
					queue.add(vertex);
					visited[vertex] = true;
				}
			}
		}

		for(int i = 0; i<num_vertices;i++){
			if(!visited[i]){
				System.out.println(" "+i);
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
		g.BFSTraversal(2);
	}
}

