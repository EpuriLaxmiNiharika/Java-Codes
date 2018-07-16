import java.util.*;


class Graph{

	class Edge{
        int src, dest;
    };

    class set{
    	int rank;
    	int parent;

    	set(){
    		rank = 0;
    	}
    }

	int number_vertices;

	Edge[] edges;

	set[] sets;

	Graph(int number_vertices, int number_edges){ 

		this.number_vertices = number_vertices;

		edges = new Edge[number_edges];

		sets = new set[number_vertices]; 

        for (int i=0; i<number_edges; ++i){
            edges[i] = new Edge();
        }

        for(int i = 0; i<number_vertices;i++){
        	sets[i] = new set();
        	sets[i].parent = i; // each vertex belongs to it's own set. so initially it is parent to itself
        }

	}


	int find(int x){//return set in which x belongs

		if(sets[x].parent==x){

			// means x belongs to it's own set

			return sets[x].parent;
		}

		else{
			return sets[x].parent = find(sets[x].parent); // if x doesn't belong to it's own set then return the set in which it's parent belong to (x and parent belong to same set)
		}
	}

	void union(int x, int y){

		int x_set = find(x);// find the set in which x belongs to
		int y_set = find(y); // find the set in which y belongs to


		int rank_xset = sets[x_set].rank;

		int rank_yset = sets[y_set].rank;


		// union two sets

		// Attach smaller rank tree under root of high rank tree
		
		if(rank_xset<rank_yset){

			sets[x_set].parent = y_set;
		}


		else if(rank_yset<rank_xset){

			sets[y_set].parent = x_set;
		}


		else{

			sets[y_set].parent = x_set;
			sets[x_set].rank = sets[x_set].rank+1;	
		}

	}


	boolean detectCycle(){

		for(int i = 0; i<edges.length;i++){

			Edge e = edges[i];

			int set_src = find(e.src);

			int set_dest = find(e.dest);

			// System.out.println(set_src+"---"+set_dest);

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
		
		// assumption in edge in src and dest, src < dest

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