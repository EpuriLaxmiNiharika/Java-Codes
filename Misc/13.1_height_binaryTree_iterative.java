/*
    How to find height without recursion? 
    We can use level order traversal to find height without recursion. 
    The idea is to traverse level by level. 
    Whenever move down to a level, increment height by 1 (height is initialized as 0). 
    Count number of nodes at each level, stop traversing when count of nodes at next level is 0.

*/

import java.util.*;

class Node {
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
class BinaryTree 
{
     Node root;
  
    int maxDepth(Node node) {
        
        Queue<Node> queue = new LinkedList<Node>();

        int height = 0;

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            
            Node popped = queue.remove();

            if(popped==null){

                height++;
                if(queue.isEmpty()){
                    return height;
                }

                queue.add(null);
            }

            else{
                if(popped.left!=null){
                    queue.add(popped.left);
                }

                if(popped.right!=null){
                    queue.add(popped.right);
                }
            }
        }
        return height;
    }
      
    public static void main(String[] args) 
    {
        BinaryTree tree = new BinaryTree();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + 
                                      tree.maxDepth(tree.root));
    }
}