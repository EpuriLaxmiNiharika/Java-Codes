/* A tree node structure */
class Node 
{
    int data;
    Node left, right;
  
    public Node(int d) 
    {
        data = d;
        left = right = null;
    }
}
  
class BinaryTree 
{
  
    Node root;
  
    /* Helper function for getLevel().  It returns level of the data
    if data is present in tree, otherwise returns 0.*/
    static boolean found = false;
    void getLevelUtil(Node node, int data, int level) 
    {
        if (node == null)
            return ;
  
        if (node.data == data && !found){
        	found= true;
            System.out.println(level);
            return;
        }
  
        if(!found)getLevelUtil(node.left, data, level + 1);
       	if(!found)getLevelUtil(node.right, data, level + 1);
    }
  
    /* Returns level of given data value */
    void getLevel(Node node, int data) {
         getLevelUtil(node, data, 1);
          
          if(!found){
            	System.out.println("not found");
          }
    }
  
    /* Driver function to test above functions */
    public static void main(String[] args) 
    {
        BinaryTree tree = new BinaryTree();
  
        /* Constructing tree given in the above figure */
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        
        for (int x = 1; x <= 6; x++) 
        {
            tree.getLevel(tree.root, x);
            tree.found = false;   
        }
    }
}