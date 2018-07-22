class Node{

	int value;
	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}

class Wrapper{

	int value;
}


class BinaryTree{

	Node root;

	
	Node removeNodes(Node node, Wrapper wrapper, int req_sum){

		if(node==null){
			return null;
		}

		Wrapper left_sum = new Wrapper(); left_sum.value = node.value + wrapper.value;
		Wrapper right_sum = new Wrapper(); right_sum.value = node.value + wrapper.value;

		node.left = removeNodes(node.left,left_sum,req_sum);

		node.right = removeNodes(node.right,right_sum,req_sum);

		wrapper.value = Math.max(left_sum.value,right_sum.value);

		if(wrapper.value<req_sum){

			node = null;
		}
		return node;
	}

	static void inorder(Node n){

		if(n==null){
			return;
		}

		inorder(n.left);
		System.out.print(n.value+" ");
		inorder(n.right);
	}


	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
 
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(12);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.left.right = new Node(11);
        tree.root.left.left.right.left = new Node(13);
        tree.root.left.left.right.right = new Node(14);
        tree.root.left.left.right.right.left = new Node(15);

        Wrapper wrapper = new Wrapper();
        wrapper.value = 0;

       	System.out.println("Tree before truncation");
        tree.inorder(tree.root);
 
        tree.removeNodes(tree.root, wrapper,45);
 
        System.out.println("\nTree after truncation");
        tree.inorder(tree.root);
	}
}