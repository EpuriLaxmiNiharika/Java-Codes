class Node{
	int value;
	Node left;
	Node right;
	public Node(int value){
		this.value = value;
	}
}

class LevelOrder{
	Node root;

	public void printLineByLine(){
		int height_tree = height(root);
		for(int level = 1 ; level <= height_tree ; level++){
			printNodes_inLevel(root,level);
			System.out.print("\n");
		}
	}

	public void printNodes_inLevel(Node rootNode, int level){
		if(rootNode==null){
			return;
		}
		if(level==1){
			System.out.print(" "+rootNode.value);
			return;
		}

		printNodes_inLevel(rootNode.left,level-1);
		printNodes_inLevel(rootNode.right,level-1);
	}

	public int height(Node rootNode){
		if(rootNode==null){
			return 0;
		}
		int height1 = height(rootNode.left);
		int height2 = height(rootNode.right);

		if(height1>height2){
			return 1 + height1;
		}
		return 1 + height2;
	}

	public static void main(String[] args) {
		LevelOrder tree = new LevelOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.printLineByLine();
	}
}