import java.util.*;


class Graph{

	class Edge{
        int src, dest;
    };

	int number_vertices;

	int[] parent;

	Edge[] edges;

	Graph(int number_vertices, int number_edges){ 

		this.number_vertices = number_vertices;

		edges = new Edge[number_edges];
        for (int i=0; i<number_edges; ++i){
            edges[i] = new Edge();
        }

		parent = new int[number_vertices]; // each vertex initially belong to their own set

		Arrays.fill(parent,-1);
	}


	int find(int x){//return set in which x belongs

		if(parent[x]==-1){

			// means x belongs to it's own set

			return x;
		}

		else{
			return find(parent[x]);
		}
	}

	void union(int x, int y){

		int find_x = find(x);// find the set in which x belongs to
		int find_y = find(y); // find the set in which y belongs to

		// union two sets

		parent[find_y] = find_x;

	}


	boolean detectCycle(){

		for(int i = 0; i<edges.length;i++){

			Edge e = edges[i];

			int set_src = find(e.src);

			int set_dest = find(e.dest);

			 // System.out.println(e.src+"---"+e.dest+"----"+set_src+"---"+set_dest);

			if(set_src!=set_dest){

				union(e.src,e.dest);
			}

			else{ // if both src and dest of edge belongs to same set => there is cycle

				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		
		int V = 3, E = 3;
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
 
        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;
 
        // add edge 0-2
        graph.edges[2].src = 0;
        graph.edges[2].dest = 2;

        if(graph.detectCycle()){

        	System.out.println("YES Cycle present");
        }

        else{
        	System.out.println("NO Cycle IS ABSENT");
        }
	}
}