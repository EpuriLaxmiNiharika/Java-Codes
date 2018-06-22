class Node{
	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}

class BST{

	Node root;

	void kth_largest(int k){ // reverse MORRIS
		
	   Node current = root;
       int count = 0;

       while (current!=null) {
            
            if(current.right!=null){
                Node pre = current.right;
                while (pre.left!=null && pre.left!=current) {
                    pre= pre.left;
                }
                if(pre.left==null){
                    pre.left = current;
                    current = current.right;
                }
                else {
                    count++;
                    if(count==k){
                        System.out.print(current.value);
                        return;
                    }
                    pre.left = null;
                    current = current.left;
                }
            }
            else{
                count++;
                if(count==k){
                    System.out.print(current.value);
                    return;
                }
                current = current.left;
            }

       }

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

        tree.kth_largest(1);
 
	}
}