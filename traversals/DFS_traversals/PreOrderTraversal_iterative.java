import java.util.Stack;

class Node{
	Node leftChild;
	Node rightChild;
	int value;
	public Node(int value){
		this.value = value;
		leftChild = rightChild  = null;
	}
}

class BinaryTree{

	Node root;
	Stack<Node> stack = new Stack<Node>();

	BinaryTree(){
		root = null;
	}

	void preorderTraversal(){
		if(root==null){
			return;
		}

		Node temp = root;
		stack.push(temp);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(" "+temp.value);
			if(temp.rightChild!=null){
				stack.push(temp.rightChild);
			}
			if(temp.leftChild!=null){
				stack.push(temp.leftChild);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.leftChild = new Node(2);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(4);
        tree.root.leftChild.rightChild = new Node(5);
          
        tree.preorderTraversal();
	}
}