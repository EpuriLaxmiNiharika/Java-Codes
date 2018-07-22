class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class BinaryTree{

	Node root1;
	Node root2;

	boolean isIsomorphic(Node node1, Node node2){

		if(node1==null && node2==null){
			return true;
		}

		if(node1==null || node2==null){
			return  false;
		}

		if(node1.value!=node2.value){
			return false;
		}

		return (isIsomorphic(node1.left,node2.left) && isIsomorphic(node1.right,node2.right)) || (isIsomorphic(node1.right,node2.left) && isIsomorphic(node1.left,node2.right));

	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
         
        // Let us create trees shown in above diagram
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.right.left = new Node(6);
        tree.root1.left.right.left = new Node(7);
        tree.root1.left.right.right = new Node(8);
  
        tree.root2 = new Node(1);
        tree.root2.left = new Node(3);
        tree.root2.right = new Node(2);
        tree.root2.right.left = new Node(4);
        tree.root2.right.right = new Node(5);
        tree.root2.left.right = new Node(6);
        tree.root2.right.right.left = new Node(8);
        tree.root2.right.right.right = new Node(7);

        if (tree.isIsomorphic(tree.root1, tree.root2))
            System.out.println("Yes");
        else
            System.out.println("No");
	}
}