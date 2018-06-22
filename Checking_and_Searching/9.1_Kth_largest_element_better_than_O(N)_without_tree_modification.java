class Node{
	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class Count{
		int value;
		Count(int value){
			this.value = value;
		}
	}

class BST{

	Node root;
	static int c = 0;

	void kth_largest(Node root,int k){
		
		if(root==null || c>=k){
			return;
		}

		kth_largest(root.right,k);
	
		c = c+1;
	
		if(c==k){
			System.out.println(root.value);
			return;
		}
		kth_largest(root.left,k);

	}

	void insert(int data){
        this.root = this.insertRec(this.root, data);
    }
     
    /* A utility function to insert a new node 
    with given key in BST */
    Node insertRec(Node node, int data)
    {   
        /* If the tree is empty, return a new node */
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }
 
        if (data == node.value) {
            return node;
        }
         
        /* Otherwise, recur down the tree */
        if (data < node.value) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

	public static void main(String[] args) {
		BST tree = new BST();
         
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        Count count = new Count(0);
        tree.kth_largest(tree.root,3);
 
	}
}