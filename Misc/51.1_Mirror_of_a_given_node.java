class Node{

    int data;
    Node left, right;
  
    public Node(int d){
        data = d;
        left = right = null;
    }
}
  
class BinaryTree {
    
    Node root;
  
    int findMirrorUtil(int target, Node left, Node right){

        if(left==null || right==null){
            return 0;
        }

        if(left.data==target){
            return right.data;
        }

        if(right.data==target){

            return left.data;
        }

        int mirror_value = findMirrorUtil(target,left.left, right.right);

        if(mirror_value==0){

            mirror_value = findMirrorUtil(target,left.right,right.left);
        }

        return mirror_value;
    }

    int findMirror(int target){

        if(target==root.data){
            return 0;
        }

        return findMirrorUtil(target,root.left,root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        Node root                   = new Node(1);
        root.left                 = new Node(2);
        root.left.left            = new Node(4);
        root.left.left.right     = new Node(7);
        root.right                 = new Node(3);
        root.right.left           = new Node(5);
        root.right.right          = new Node(6);
        root.right.left.left     = new Node(8);
        root.right.left.right    = new Node(9);

        tree.root = root;

        System.out.println(tree.findMirror(4));
    }
}