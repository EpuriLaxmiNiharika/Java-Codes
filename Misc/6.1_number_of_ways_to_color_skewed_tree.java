/*
	

	Note that only the root and children (children, grand children, grand grand children …. and all) 
	should have different colors. 
	The root of the tree can choose any of the K colors so K ways. 
	Every other node can choose other K-1 colors other than its parent. 
	So every node has K-1 choices.
	Here, we select the tree as every node as only one child. 
	We can choose any of the K colors for the root of the tree so K ways. 
	And we are left with K-1 colors for its child. So for every child we can assign a color 
	other than its parent. Thus, for each of the N-1 nodes we are left with K-1 colors. 
	Thus the answer is K*(K-1)^(N-1).

	// K*(K-1)^(N-1) its "and" operation

*/


class BinaryTree{

	static void num_ways_colorTree(int size, int k){

		int res = k * (int)Math.pow(k-1,size-1);
		System.out.println(res);
	}

	public static void main(String[] args) {
		
		num_ways_colorTree(3,3);
	}
}