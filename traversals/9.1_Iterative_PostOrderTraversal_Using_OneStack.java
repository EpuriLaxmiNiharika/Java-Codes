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

	public void postOrderTraversal(){

		Stack <Node> stack = new Stack<Node>();

		Node temp = root;

		if(temp!=null){
			stack.push(temp);
		}

		while (!stack.isEmpty()) {
			
			temp = stack.pop();

			if(!temp.visited){
				temp.visited = true;
				stack.push(temp);
				if(temp.right!=null){
					stack.push(temp.right);
				}
				if(temp.left!=null){
					stack.push(temp.left);
				}
			}
			else{
				System.out.print(" "+temp.value);
			}

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
