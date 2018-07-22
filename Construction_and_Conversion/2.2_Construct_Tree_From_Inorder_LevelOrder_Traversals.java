// Maintaining 2 queueus for level order nodes in left subtree and right subtree

import java.util.HashSet;
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

	BinaryTree(){
	}

	// Inorder -- left root right

	public Node buildTree( int[] levelOrder, int[] inOrder, int start, int end){

		if(start>end){
			return null;
		}

		if(start==end){

			return new Node(inOrder[start]);
		}

		Node root_node = new Node(levelOrder[0]);

		int index = start;

		for(index = start; index<=end; index++){

			if(levelOrder[0]==inOrder[index]){
				break;
			}
		}

		// all nodes to left of i -- left subtree and right -- right subtree


		HashSet<Integer> left_nodes = new HashSet<Integer>(); // stores inorder nodes in left subtree
		for(int j = start; j<=index-1;j++){

			left_nodes.add(inOrder[j]);
		}

		// build left and right level order queues for left and right subtrees		
		int[] leftLevelNodes = new int[left_nodes.size()];
		int[] rightLevelNodes = new int[end-start-left_nodes.size()];

		int leftIndex = 0;
		int rightIndex  = 0;


		for(int i = 1; i<levelOrder.length;i++){

			if(left_nodes.contains(levelOrder[i])){
				leftLevelNodes[leftIndex] = levelOrder[i];
				leftIndex++;
			}
			else{
				rightLevelNodes[rightIndex] = levelOrder[i];
				rightIndex++;
			}
		}

		root_node.left = buildTree( leftLevelNodes, inOrder,  start, index-1);

		root_node.right = buildTree( rightLevelNodes, inOrder,  index+1, end);

		return root_node;
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
        Node root = tree.buildTree(level,in,0,in.length-1);
        
        System.out.println("Level traversal of constructed tree is : ");

        tree.printInorder(root);
	}
}