import java.util.*;

class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value =value;
		left = null;
		right = null;
	}

}

class BinaryTree{

	Node root;



	// Inorder -- left root right

	public Node buildTree(int[] levelOrder, int[] inOrder, int start, int end){

		if(start>end){return null;}

		if(start==end){
		//	System.out.print(inOrder[start]+" ");
		}

		int node = levelOrder[0];

		Node node1 = new Node(node);

		int index = start;

		for (index = start; index<=end;index++ ) {
			
			if(inOrder[index]==node){
				break;
			}
		}

		ArrayList<Integer> left_inorder_nodes = new ArrayList<Integer>();

		
		for(int i = start;i<index;i++){

			left_inorder_nodes.add(inOrder[i]);
		}

		int[] leftLevel = new int[index-start];
		int[] rightLevel = new int[end-index];
		int p = 0, k = 0;
		for(int i = 1; i<levelOrder.length;i++){

			if(left_inorder_nodes.contains(levelOrder[i])){

				leftLevel[p] = levelOrder[i];
				p++;
			}
			else{
				rightLevel[k] = levelOrder[i];
				k++;
			}
		}

		node1.left = buildTree(leftLevel,inOrder,start,index-1);
		System.out.print(node1.value+"  ");
		node1.right = buildTree(rightLevel,inOrder,index+1,end);
		return node1;
	}


	
	public void printInorder(Node node){
 		if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
	}


	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        int len = in.length;
        tree.root = tree.buildTree(level,in,0,in.length-1);
       tree.printInorder(tree.root);
	}
}