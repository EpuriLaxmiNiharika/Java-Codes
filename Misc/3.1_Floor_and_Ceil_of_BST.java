class Node{

	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
	}
}



class BST{

	static class Values{

		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;
	}

	Node root;

	Node insertNode(Node node, int value){

		if(node==null){

			return new Node(value);
		}
		
		if(node.value>value){
			node.left = insertNode(node.left,value);
		}
		else{
			node.right = insertNode(node.right,value);
		}

		return node;
	}


	void FloorCeil_BST(Node n, int value, Values values){



		if(n==null){
			return;
		}

		if(n.value==value){
			values.floor = value;
			values.ceil = value;
		}

		else if(n.value<value){

			if(values.floor<n.value){ // GETTING FLOOR CLOSER TO VALUE
				values.floor = n.value;
			}

			FloorCeil_BST(n.right,value,values);
		}

		else{

			if(values.ceil>n.value){ // GETTING CEIL CLOSER TO VALUE
				values.ceil = n.value;
			}

			FloorCeil_BST(n.left,value,values);
		}
	}

	public static void main(String[] args) {
		

		BST tree = new BST();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        
     
        Values values = new Values();

        for (int i = 0; i < 16; i++) {
           	
           	tree.FloorCeil_BST(tree.root, i,values);
           	if(values.floor==Integer.MIN_VALUE){
           		values.floor = -1;
           	}
           	if(values.ceil == Integer.MAX_VALUE){
           		values.ceil = -1;
           	}

            System.out.println(values.floor+" :---"+i+"----: "+values.ceil);
            values = new Values();
        }
		
	}
}