Method 1 (Graph)

We can model the solution using graphs. 
Initialize indegree and outdegree of every vertex as 0. 
If A knows B, draw a directed edge from A to B, increase indegree of B and outdegree of A by 1. 
Construct all possible edges of the graph for every possible pair [i, j]. 
We have NC2 pairs. If celebrity is present in the party, we will have one sink node in the graph 
with outdegree of zero, and indegree of N-1. We can find the sink node in (N) time, 
but the overall complexity is O(N2) as we need to construct the graph first.