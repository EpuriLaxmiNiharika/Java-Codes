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

	void BFSTraversal(){

		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean visited[] = new boolean[num_vertices];

		for(int i = 0; i<num_vertices;i++){
			visited[i] = false;
		}

		queue.add(0);
		visited[0]= true;
		ArrayList<Integer> nodes_level = new ArrayList<Integer>();

		while (!queue.isEmpty()) {
			int count_nodes = queue.size();	
			nodes_level.add(count_nodes);	
			while(count_nodes>0){
				int dequeued = queue.remove();
				count_nodes--;
				for(Integer vertex: adj_lst[dequeued]){
					if(!visited[vertex]){
						visited[vertex] = true;
						queue.add(vertex);
					}
				}
			}
		}

		printArrList(nodes_level);
	}

	void printArrList(ArrayList<Integer> arrLst){
		System.out.print("\n");
		
		for(int i : arrLst){
			System.out.print(i+" ");
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 3);
	    g.addEdge(2, 4);
	    g.addEdge(2, 5);
	 
	    int level = 2;
	 
	    g.BFSTraversal();
	}
}