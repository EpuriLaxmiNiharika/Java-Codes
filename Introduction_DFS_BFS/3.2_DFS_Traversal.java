//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/


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

		while(!stack.isEmpty()){
			//printStack(stack);
			
			int popped = stack.peek();
			
			if(!visited[popped]){
				System.out.print(" "+popped);
				visited[popped] = true;
			}

			if(adj_lst[popped].size()==0){
				stack.pop();
			}

			else{
				int un_visted = 0;
				for(int element: adj_lst[popped]){
					if(!visited[element]){
						un_visted++;
						stack.push(element);
					//	System.out.println(popped + " --> "+element);
						break;
					}
				}

				if(un_visted ==0){
					stack.pop();
				}
			}
		}
	}

	void printStack(Stack<Integer> s){
		System.out.print("\n");
		for(int element:s ){
			System.out.print(" "+element);
		}
		System.out.print("\n");
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

