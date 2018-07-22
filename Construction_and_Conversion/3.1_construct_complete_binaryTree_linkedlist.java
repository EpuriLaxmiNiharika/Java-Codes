import java.util.*;

class TreeNode{

	int value;
	TreeNode left;
	TreeNode right;

	TreeNode(int value){
		this.value = value;
	}
}

class LinkedListNode{

	int value;
	LinkedListNode next;

	LinkedListNode(int value){

		this.value = value;
	}
}



class BinaryTree{

	TreeNode root;
	LinkedListNode head;

	void push(int new_data){
        // allocate node and assign data
        LinkedListNode new_node = new LinkedListNode(new_data);
  
        // link the old list off the new node
        new_node.next = head;
  
        // move the head to point to the new node
        head = new_node;
    }

	void buildTree(){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		LinkedListNode temp = head;

		root = new TreeNode(temp.value);
		queue.add(root);

		while (temp!=null && !queue.isEmpty()) {
			// System.out.println(temp.value);
			TreeNode popped = queue.remove();
			if(temp.next!=null){
				temp = temp.next;
				popped.left = new TreeNode(temp.value);
				queue.add(popped.left);
				
				if(temp.next!=null){
					temp = temp.next;
					popped.right = new TreeNode(temp.value);
					// System.out.println(temp.value+"!!!");
					queue.add(popped.right);
					// System.out.println(popped.value+"--"+popped.left.value+"---"+popped.right.value);
				}
			}
		}
	}

	void inorderTraversal(TreeNode node) {
        if (node != null) 
        {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.push(36); /* Last node of Linked List */
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10); /* First node of Linked List */
        tree.buildTree();
        tree.inorderTraversal(tree.root);
	}
}