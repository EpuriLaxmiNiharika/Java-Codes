
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

	public Node buildTree(Node root_node, int[] levelOrder, int[] inOrder, int start, int end){

		if(start>end){
			return null;
		}


		// first node of level order -- root node
		int found = 0;
		int index = -1; // 0
		for(int level = 0; level<levelOrder.length; level++){
			for(int in = start; in<=end; in++){
				if(inOrder[in] == levelOrder[level]){
					root_node = new Node(inOrder[in]);
					index = in;
					found =1;
					break;
				}
			}
			if(found==1){
				break;
			}
		}

		if(found==1){
			root_node.left = buildTree(root_node,levelOrder,inOrder,start,index-1);
			root_node.right = buildTree(root_node,levelOrder,inOrder,index+1,end);
		}

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
        Node root = tree.buildTree(null,level,in,0,in.length-1);
        
        System.out.println("Level traversal of constructed tree is : ");

        tree.printInorder(root);
	}
}