import java.util.Stack;
class Node{
	int value;
	Node left;
	Node right;
	boolean visited;
	
	Node(int value){
		this.value = value;
		left = right  = null;
		visited = false;
	}
}

class BinaryTree{
	Node root;

	public void postOrderTraversal(){ // left right root

		Stack <Node> stack1 = new Stack<Node>();
		Stack <Node> stack2 = new Stack<Node>(); 

		Node temp = root;

		stack1.push(temp);

		while (!stack1.isEmpty()) {
			temp = stack1.pop();
			stack2.push(temp);
			if(temp.left!=null){
				stack1.push(temp.left);
			}

			if(temp.right!=null){
				stack1.push(temp.right);
			}
		}

		while(!stack2.isEmpty()){
			System.out.print(" "+stack2.pop().value);
		}
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
          
        tree.postOrderTraversal();
	}
}
