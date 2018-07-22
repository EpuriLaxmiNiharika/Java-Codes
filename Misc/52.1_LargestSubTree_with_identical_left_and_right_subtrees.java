class BinaryTree{

	int largestIdenticalSubtrees(){

		// level order traversal // get the root of each subtree

		// call isIdentical with (root.left, root.right)
	}
}

 boolean isIdentical(Node node1, Node node2){

    	if(node1==null && node2==null){
    		return  true;
    	}

    	if(node2==null || node1==null){
    		return false;
    	}

    	return (node2.data==node1.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right,node2.right);
    }